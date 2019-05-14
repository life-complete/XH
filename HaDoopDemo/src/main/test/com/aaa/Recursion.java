package com.aaa;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//递归
public class Recursion {
    @Test
    public void getpath() {
        String url = "/";
        setpath(url);
    }

    public void setpath(String path) {
        System.out.println(path);
        FileSystem fileSystem = null;
        try {
            //fileSystem=FileSystem.get(new URI("hdfs://192.168.152.111:9000"),new Configuration(),"root");
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), new Configuration(), "root");
            //FileStatus[] fileStatuses=fileSystem.listStatus(new Path(path));
            FileStatus[] fileStatuses = fileSystem.listStatus(new Path(path));
            System.out.println("abcd" + fileStatuses);
            if (fileStatuses != null && fileStatuses.length > 0) {
                for (FileStatus fileStatus : fileStatuses) {
                    if (fileStatus.isFile()) {
                        System.out.println("这是文件: " + fileStatus.getPath());
                    } else {
                        System.out.println("这是目录: " + fileStatus.getPath());
                        setpath(fileStatus.getPath().toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileSystem != null)
                    fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
