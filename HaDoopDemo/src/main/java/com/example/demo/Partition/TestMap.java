package com.example.demo.Partition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TestMap extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text text = new Text();
    private IntWritable intWritable = new IntWritable();

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split(",");
        text.set(words[0]);
        text.set(words[1]);
        text.set(words[2]);
        context.write(text, intWritable);

    }
}

