package com.aaa;

import java.io.*;

public class test {
    public static void main(String[] args) {
        aa();
    }

    public static void aa() {
        File file = new File("D:\\aaa.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream("D:/asd.txt");
            byte[] by = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(by)) != 0) {
                outputStream.write(by, 0, len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
