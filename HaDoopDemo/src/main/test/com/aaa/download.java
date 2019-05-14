package com.aaa;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class download {
    public static void main(String[] args) {
        down02();
    }

    public static void down01() {
        FileSystem fileSystem = null;
        FSDataInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), new Configuration(), "root");
            inputStream = fileSystem.open(new Path("/mydir/a/jdk-8u162-windows-x64.exe"));
            outputStream = new FileOutputStream("D:/test/jdk1.rpm");
            byte[] b = new byte[1024];
            for (int len = 0; len < 1024 * 128; len++) {
                inputStream.read(b);
                outputStream.write(b);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void down02() {
        FileSystem fileSystem = null;
        FSDataInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), new Configuration(), "root");
            inputStream = fileSystem.open(new Path("/mydir/a/jdk-8u162-windows-x64.exe"));
            outputStream = new FileOutputStream("D:/test/jdk2.rpm");
            byte[] b = new byte[1024];
            inputStream.seek(1024 * 128 * 1024);
            int len = 0;
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
