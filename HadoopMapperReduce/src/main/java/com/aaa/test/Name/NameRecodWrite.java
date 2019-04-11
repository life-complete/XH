package com.aaa.test.Name;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class NameRecodWrite extends RecordWriter<Text, IntWritable> {
    private FSDataOutputStream FirstName;
    private FSDataOutputStream SecondName;
    private FSDataOutputStream ThirdName;

    public NameRecodWrite(TaskAttemptContext taskAttemptContext){
        //获取配置
        Configuration configuration = taskAttemptContext.getConfiguration();
        FileSystem fileSystem =  null;
        try {
            //获取文件系统对象
            fileSystem = FileSystem.get(configuration);
            //创建输出流
            FirstName = fileSystem.create(new Path("D:\\mapreduce\\fn.txt"));
            SecondName = fileSystem.create(new Path("D:\\mapreduce\\sn.txt"));
            ThirdName = fileSystem.create(new Path("D:\\mapreduce\\tn.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            IOUtils.closeStream(fileSystem);
        }
    }


    @Override
    public void write(Text text, IntWritable intWritable) throws IOException, InterruptedException {
        String name=text.toString();
        String nameStr="赫连皇甫";
        String nameStr2="上官南宫";
        String substring=name.substring(0,2);
        if(nameStr.contains(substring)){
            String text1=name+","+intWritable.get()+"\r\n";
            FirstName.write(text1.getBytes(),0,text1.getBytes().length);
        }
        else if(nameStr2.contains(substring)){
            String text2=name+","+intWritable.get()+"\r\n";
            SecondName.write(text2.getBytes(),0,text2.getBytes().length);
        }
        else{
            //ThirdName.write(name.trim()+","+intWritable.get());
            String text3=name+","+intWritable.get()+"\r\n";
            ThirdName.write(text3.getBytes(),0,text3.getBytes().length);
        }

    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        IOUtils.closeStream(FirstName);
        IOUtils.closeStream(SecondName);
        IOUtils.closeStream(ThirdName);
    }
}
