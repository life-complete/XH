package com.example.demo.com.aaa.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class DriverTest {
    public static void main(String[] args) {
        //System.load("F:\\app\\hadoop-2.6.1");
        try {
            //获取任务信息
            Configuration configuration = new Configuration();
            Job job = Job.getInstance(configuration);
            //获取该任务使用jar包的位置
            job.setJarByClass(DriverTest.class);
            //关联自定义的mapper和reduce
            job.setMapperClass(MapTest.class);
            job.setReducerClass(ReduceTest.class);
            //设置mapper输出类型
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Game.class);
            //设置最终输出类型
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Game.class);
            //设置输入输出路径
            FileInputFormat.setInputPaths(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            //提交任务
            job.waitForCompletion(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}