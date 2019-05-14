package com.example.demo.Partition;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Test implements Writable {
    private long ss;
    private long bs;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(ss);
        dataOutput.writeLong(bs);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        ss = dataInput.readLong();
        bs = dataInput.readLong();
    }
}
