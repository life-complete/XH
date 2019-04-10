package com.aaa.test.test;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Test implements Writable {
    private Long ss;
    private Long ds;
    @Override
    public void write(DataOutput dataOutput) throws IOException {
     dataOutput.writeLong(ss);
     dataOutput.writeLong(ds);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        ss=dataInput.readLong();
        ds=dataInput.readLong();
    }

    @Override
    public String toString() {
        return "Game{" +
                "killNum=" + ss +
                ", killedNum=" + ds +
                '}';
    }
    public Test(){

    }
    public Test(long ss,long ds){
        this.ss=ss;
        this.ds=ds;

    }
    public Long getSs() {
        return ss;
    }

    public void setSs(Long ss) {
        this.ss = ss;
    }

    public Long getDs() {
        return ds;
    }

    public void setDs(Long ds) {
        this.ds = ds;
    }
}
