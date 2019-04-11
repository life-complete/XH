package com.aaa.test.Name;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class NameOutPutFormart extends FileOutputFormat<Text, IntWritable> {


    @Override
    public RecordWriter<Text, IntWritable> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        return new NameRecodWrite(taskAttemptContext);
    }
}
