package com.aaa.test.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class DriverTest {
    public static void main(String[] args) {
        try {
            Configuration configuration=new Configuration();
            Job job=Job.getInstance(configuration);
            //获取任务使用jar包位置
            job.setJarByClass(DriverTest.class);
            //定义使用的mapper 和reduce
            job.setMapperClass(MapTest.class);
            job.setReducerClass(ReduceTest.class);
            //设置mapper 输出输入类型
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Test.class);
            //设置最终输出类型
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Test.class);
            //设置输入输出路径
            FileInputFormat.setInputPaths(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            //提交任务
            job.waitForCompletion(true);
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
