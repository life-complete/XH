package com.aaa.test.test;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ReduceTest extends Reducer<Text,Test,Text,Test> {
    protected void reduce(Text key, Iterable<Test> values, Context context) throws IOException, InterruptedException {
        long ss=0;
        long ds=0;
        for (Test test : values) {
            ss+=test.getSs();
            ds+=test.getDs();
        }
        context.write(key,new Test(ss,ds));
    }
}
