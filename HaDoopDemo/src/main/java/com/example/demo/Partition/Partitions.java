package com.example.demo.Partition;


import org.apache.hadoop.mapreduce.Partitioner;

public class Partitions extends Partitioner {
    @Override
    public int getPartition(Object o, Object o2, int i) {
        String dname = o.toString().substring(0, 2);
        switch (dname) {
            case "13":
                return 0;
            case "15":
                return 1;
            case "18":
                return 2;
        }
        return 3;
    }

}
