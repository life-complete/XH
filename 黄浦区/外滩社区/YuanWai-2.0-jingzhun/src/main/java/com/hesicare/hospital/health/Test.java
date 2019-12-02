package com.hesicare.hospital.health;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {
    public static void main(String[] args) {
        String filename="D:/test/logs.txt";
        for (int i = 0; i < 5; i++) {
            FileWriter fileWriter=null;
            try {
                File f=new File(filename);
                File parent=f.getParentFile();
                if (!parent.exists()){
                    parent.mkdirs();}
                if (!f.exists()){
                    f.createNewFile();}
                fileWriter=new FileWriter(f,true);
                PrintWriter printWriter=new PrintWriter(fileWriter);
                printWriter.println("123456"+"\r\n");
                printWriter.flush();
                fileWriter.flush();
                printWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
