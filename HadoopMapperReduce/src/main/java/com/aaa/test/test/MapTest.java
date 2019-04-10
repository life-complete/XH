package com.aaa.test.test;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapTest extends Mapper<LongWritable, Text,Text, Test >{
    private Text text = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] values = value.toString().split(",");
            text.set(values[1]);
            context.write(text,new Test(Long.valueOf(values[3]),Long.valueOf(values[4])));
    }
}
