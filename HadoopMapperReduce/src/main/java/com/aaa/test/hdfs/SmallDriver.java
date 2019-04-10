package com.aaa.test.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SmallDriver {
    public static void main(String[] args) {
        try {
            args = new String[]{"D:\\a","d:/output2/"};
            //获取任务信息
            Configuration configuration  = new Configuration();
            Job job = Job.getInstance(configuration);
            //获取该任务使用jar包的位置
            job.setJarByClass(SmallDriver.class);
            //设置自定义的文件读对象
            job.setInputFormatClass(SmallFileInput.class);

            //关联自定义的mapper和reduce
            job.setMapperClass(SmallMap.class);
            job.setReducerClass(SmallReducer.class);

            //设置mapper输出类型
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(BytesWritable.class);
            //设置最终输出类型
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(BytesWritable.class);

            //设置输入输出路径
            FileInputFormat.setInputPaths(job,new Path(args[0]));
            FileOutputFormat.setOutputPath(job,new Path(args[1]));
            //提交任务
            job.waitForCompletion(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
