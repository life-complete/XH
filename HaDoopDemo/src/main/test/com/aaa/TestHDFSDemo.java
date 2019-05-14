package com.aaa;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * fileName:TestHDFSDemo
 * description:
 * author:zz
 * createTime:2019/3/28 17:29
 */
public class TestHDFSDemo {

    /**
     * 上传
     */
    @Test
    public void testUploadFileToHdfs() {
        Configuration configurable = new Configuration();
        FileSystem fileSystem = null;
        try {
            //如果在设置配置参数，优先级别高于在配置文件中配置。。。。。
            configurable.set("dfs.replication", "2");
            //实例化FileSystem
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), configurable, "root");
            //复制本地文件到hdfs
            fileSystem.copyFromLocalFile(new Path("D:\\深圳实训2\\sanguo.txt"), new Path("/mydir/books/"));
            System.out.println("上传成功。。。");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fileSystem != null) {
                    fileSystem.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 下载
     */
    @Test
    public void testDownloadFile() {
        FileSystem fileSystem = null;
        try {
            //实例化FileSystem
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //下载文件
            fileSystem.copyToLocalFile(true, new Path("/mydir/books/sanguo.txt"), new Path("D:\\shuihu.txt"), true);
            System.out.println("下载完毕。。。");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileSystem != null) ;
                fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试创建目录
     */
    @Test
    public void testCreateDirectory() {
        FileSystem fileSystem = null;
        try {
            //实例化FileSystem
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //创建目录
            fileSystem.mkdirs(new Path("/mydir1/images/"));
            System.out.println("创建完毕。。。");
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

    /**
     * 测试删除目录或者文件
     */
    @Test
    public void testDeleteFile() {
        FileSystem fileSystem = null;
        try {
            //实例化FileSystem
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //删除目录或者文件  目录不空时，递归删除
            fileSystem.delete(new Path("/mydir1/images"), true);
            System.out.println("删除完毕。。。");
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

    /**
     * 测试修改名称
     */
    @Test
    public void testRename() {
        FileSystem fileSystem = null;
        try {
            //实例化FileSystem
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            // 修改文件名称
            // fileSystem.rename(new Path("/mydir/jdk/jdk-8u151-linux-x64.rpm"),new Path("/mydir/jdk/jdk8.rpm"));
            //修改目录
            fileSystem.rename(new Path("/mydir1/"), new Path("/mydir3/"));
            System.out.println("修改名字完毕。。。");
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

    /**
     * 显示文件详情
     */
    @Test
    public void testShowFileDetail() {
        FileSystem fileSystem = null;
        try {
            //实例化FileSystem
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //为true查找子孙目录下的所有文件   false只返回当前目录下的文件
            RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/mydir/jdk"), false);
            //循环遍历
            while (files.hasNext()) {
                LocatedFileStatus fileStatus = files.next();
                //路径
                Path path = fileStatus.getPath();
                System.out.println(path);
                //名称
                System.out.println("名字：" + path.getName());
                //长度
                System.out.println("长度：" + fileStatus.getLen());
                //权限
                System.out.println("权限：" + fileStatus.getPermission());
                //组
                System.out.println("组：" + fileStatus.getGroup());
                //获取存储块的信息
                BlockLocation[] blockLocations = fileStatus.getBlockLocations();
                for (BlockLocation blockLocation : blockLocations) {
                    String[] names = blockLocation.getNames();
                    String[] hosts = blockLocation.getHosts();
                   /* for (String host : hosts) {
                        System.out.println("副本位置："+host);
                    }*/
                    for (int i = 0; i < hosts.length; i++) {
                        String host = hosts[i];
                        System.out.println("副本位置：" + host);
                        System.out.println("副本name：" + names[i]);
                    }
                }
                System.out.println("===============================================");
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

    /**
     * 递归
     *
     * @param path
     */
    public void testRecursive(String path) {
        FileSystem fileSystem = null;
        try {
            Configuration conf = new Configuration();
            // conf.set("dfs.replication","2");
            fileSystem = FileSystem.get(new URI("hdfs://192.168.152.111:9000"), conf, "root");
            FileStatus[] fileStatuses = fileSystem.listStatus(new Path(path));
            if (fileStatuses != null && fileStatuses.length > 0) {
                for (FileStatus fileStatus : fileStatuses) {
                    if (fileStatus.isFile()) {
                        System.out.println("是文件，文件名称" + fileStatus.getPath().getName() + ",文件副本数：" + fileStatus.getReplication());
                    } else {
                        System.out.println("是目录" + fileStatus.getPath());
                        testRecursive(fileStatus.getPath().toString());
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

    /**
     * 判断是否为文件
     */
    @Test
    public void testIsAfile() {
        testRecursive("/");
    }

    /**
     * 使用io流做文件上传
     */
    @Test
    public void testFileUploadUseIO() {

        FileSystem fileSystem = null;
        FileInputStream fileInputStream = null;
        FSDataOutputStream fsDataOutputStream = null;
        try {
            //获取文件系统
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //创建输入流
            fileInputStream = new FileInputStream("D:\\深圳实训2\\ecj-4.4.2.jar");
            //创建输出流
            fsDataOutputStream = fileSystem.create(new Path("/mydir/book/ecj.jar"));
            //流读写
            //IOUtils.copyBytes(fileInputStream,fsDataOutputStream,new Configuration());
            byte[] by = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(by)) != -1) {
                System.out.println("长度" + len);
                fsDataOutputStream.write(by, 0, len);
            }
            //清空管道
            fsDataOutputStream.flush();
            System.out.println("上传完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fsDataOutputStream != null)
                    fsDataOutputStream.close();
                if (fileInputStream != null)
                    fileInputStream.close();
                if (fileSystem != null)
                    fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件下载
     */
    @Test
    public void testFileDownLoadUseIO() {
        FileSystem fileSystem = null;
        FileInputStream fileInputStream = null;
        FSDataOutputStream fsDataOutputStream = null;
        try {
            //获取文件系统
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //获取输出流
            FileOutputStream fileOutputStream = new FileOutputStream("e:/a/ecj.jar");
            // 获取输入流
            FSDataInputStream fSDataInputStream = fileSystem.open(new Path("/mydir/book/ecj.jar"));
            //文件读写
            IOUtils.copyBytes(fSDataInputStream, fileOutputStream, new Configuration());
            //刷新管道
            fileOutputStream.flush();
            System.out.println("下载完毕。。。");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fsDataOutputStream != null)
                    IOUtils.closeStream(fsDataOutputStream);
                if (fileInputStream != null)
                    fileInputStream.close();
                if (fileSystem != null)
                    fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 大文件下载1
     */
    @Test
    public void testBigFileDownLoad1() {
        FileSystem fileSystem = null;
        FileInputStream fileInputStream = null;
        FSDataOutputStream fsDataOutputStream = null;
        try {
            //获取文件系统
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //获取输出流
            FileOutputStream fileOutputStream = new FileOutputStream("e:/jdk8.rpm.part1");
            // 获取输入流
            FSDataInputStream fSDataInputStream = fileSystem.open(new Path("/mydir/jdk/jdk8.rpm"));
            //文件读写
            // IOUtils.copyBytes(fSDataInputStream,fileOutputStream,new Configuration());
            byte[] by = new byte[1024];
            for (int i = 0; i < 1024 * 128; i++) {
                fSDataInputStream.read(by);
                fileOutputStream.write(by);
            }
            //刷新管道
            fileOutputStream.flush();
            System.out.println("第一部分下载完毕。。。");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fsDataOutputStream != null)
                    IOUtils.closeStream(fsDataOutputStream);
                if (fileInputStream != null)
                    fileInputStream.close();
                if (fileSystem != null)
                    fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 大文件下载2
     */
    @Test
    public void testBigFileDownLoad2() {
        FileSystem fileSystem = null;
        FileInputStream fileInputStream = null;
        FSDataOutputStream fsDataOutputStream = null;
        try {
            //获取文件系统
            fileSystem = FileSystem.get(new URI("hdfs://192.168.11.101:9000"), new Configuration(), "root");
            //获取输出流
            FileOutputStream fileOutputStream = new FileOutputStream("e:/jdk8.rpm.part2");
            // 获取输入流
            FSDataInputStream fSDataInputStream = fileSystem.open(new Path("/mydir/jdk/jdk8.rpm"));
            //定位开始位置
            fSDataInputStream.seek(1024 * 1024 * 128);
            //文件读写
            // IOUtils.copyBytes(fSDataInputStream,fileOutputStream,new Configuration());
            byte[] by = new byte[1024];
          /*  for (int i = 0; i < 1024*128; i++) {
                fSDataInputStream.read(by);
                fileOutputStream.write(by);
            }*/
            int len = 0;
            while ((len = fSDataInputStream.read(by)) != -1) {
                fileOutputStream.write(by, 0, len);
            }
            //刷新管道
            fileOutputStream.flush();
            System.out.println("第二部分下载完毕。。。");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fsDataOutputStream != null)
                    IOUtils.closeStream(fsDataOutputStream);
                if (fileInputStream != null)
                    fileInputStream.close();
                if (fileSystem != null)
                    fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
