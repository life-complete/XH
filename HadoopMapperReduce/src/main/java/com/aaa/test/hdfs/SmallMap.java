package com.aaa.test.hdfs;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class SmallMap extends Mapper<NullWritable, BytesWritable,Text,BytesWritable> {

    private Text t  = new Text();
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        //初始化的时候获取要处理的文件路径
        FileSplit fileSplit =(FileSplit)context.getInputSplit();
        String path = fileSplit.getPath().toString();
        t.set(path);
    }

    @Override
    protected void map(NullWritable key, BytesWritable value, Context context) throws IOException, InterruptedException {
        context.write(t,value);
    }
}
