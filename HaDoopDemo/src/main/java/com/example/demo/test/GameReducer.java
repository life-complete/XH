package com.example.demo.test;

import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class GameReducer extends Reducer {
    @Override
    protected void reduce(Object key, Iterable values, Context context) throws IOException, InterruptedException {

    }
}
