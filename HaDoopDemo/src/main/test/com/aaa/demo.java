package com.aaa;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class demo {
    public static void main(String[] args) {
        testdown();
    }

    public void testuo() {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), configuration, "root");
            fileSystem.copyFromLocalFile(new Path("D:\\sh.txt"), new Path("/mydir/"));
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileSystem != null) {
                    fileSystem.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testdownfile() {
        FileSystem fileSystem = null;
        Configuration configuration = new Configuration();
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), configuration, "root");
            fileSystem.copyToLocalFile(new Path("/mydir/sh.txt"), new Path("D:\\aaa.txt"));
            System.out.println("下载程功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileSystem != null) {
                    fileSystem.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testget() {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), configuration, "root");
            RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/mydir/"), true);
            System.out.println(files.hasNext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileSystem != null) {
                    fileSystem.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testFile() {
        //获取文件系统
        FileSystem fileSystem = null;
        FileInputStream fileInputStream = null;
        FSDataOutputStream fsDataOutputStream = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), new Configuration(), "root");
            fileInputStream = new FileInputStream("D:\\aaa.txt");
            fsDataOutputStream = fileSystem.create(new Path("/mydir/bbb.txt"));
            IOUtils.copyBytes(fileInputStream, fsDataOutputStream, new Configuration());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                fileSystem.close();
                fileInputStream.close();
                fsDataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testdown() {
        //获取文件系统
        FileSystem fileSystem = null;
        FileOutputStream out = null;
        FSDataInputStream input = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), new Configuration(), "root");
            input = fileSystem.open(new Path("/mydir/bbb.txt"));
            out = new FileOutputStream("D:\\ccc.txt");
            IOUtils.copyBytes(input, out, new Configuration());
//              fileSystem=FileSystem.get(new URI("hdfs://192.168.152.111:9000"),new Configuration(),"root");
//            fileInputStream=new FileInputStream("D:\\aaa.txt");
//            fsDataOutputStream=fileSystem.create(new Path("/mydir/bbb.txt"));
//            IOUtils.copyBytes(fileInputStream,fsDataOutputStream,new Configuration());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                fileSystem.close();
                input.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void down() {
        FileSystem fileSystem = null;
        FSDataInputStream inputStream = null;
        OutputStream out = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), new Configuration(), "root");
            inputStream = fileSystem.open(new Path("/mydir/a/jdk-8u162-windows-x64.exe"));
            out = new FileOutputStream("D:\\test\\jdk_8_1.rpm");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
