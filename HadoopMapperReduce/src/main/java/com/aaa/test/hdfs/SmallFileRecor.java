package com.aaa.test.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;

import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class SmallFileRecor extends RecordReader<NullWritable,BytesWritable> {

    private Configuration configuration; //配置类
    private FileSplit fileSplit;
    private boolean processed =false;
    private BytesWritable value = new BytesWritable();

    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        this.fileSplit =  (FileSplit)inputSplit;//向下转型
        configuration = taskAttemptContext.getConfiguration();
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        if(!processed) {
            FSDataInputStream fSDataInputStream = null;
            try {
                //1，定义缓冲区
                byte[] contents = new byte[(int) fileSplit.getLength()];
                //2,获取文件系统
                Path path = fileSplit.getPath();
                FileSystem fileSystem = path.getFileSystem(configuration);
                //3,读取数据
                fSDataInputStream = fileSystem.open(path);
                //4，读取内容
                IOUtils.readFully(fSDataInputStream, contents, 0, contents.length);
                //5,输出内容
                value.set(contents, 0, contents.length);
                processed =true;
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
              /* if(fSDataInputStream!=null){
                   fSDataInputStream.close();
               }*/
                IOUtils.closeStream(fSDataInputStream);
            }

        }
        return false;
    }

    @Override
    public NullWritable getCurrentKey() throws IOException, InterruptedException {
        return NullWritable.get();
    }

    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return processed?1:0;
    }

    @Override
    public void close() throws IOException {

    }
}
