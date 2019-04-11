package com.aaa.test.Name;

import org.apache.hadoop.fs.Path;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CreateName {
    public static void main(String[] args) {
       create();
    }
    public static  void create(){
       String strings="舒影荔枝丽秀娟英华慧巧美静淑惠珠莹雪琳晗瑶勤珍贞莉兰凤洁琳素云莲真环荣爱月媛艳瑞凡佳嘉叶璧璐娅琦晶妍茜秋珊莎锦婕馨瑗琰融艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育涵琴晴丽美瑶梦茜倩希夕月悦乐彤影珍依沫玉灵瑶嫣倩妍萱漩娅媛怡佩淇雨娜莹娟文芳莉雅诗乐佳涵珊莎锦黛青倩姣婉娴瑾颖雯婕馨洁琳薇菁梦岚苑";
       String[] strings1={"南宫","上官","端木","赫连","司徒","司马","皇甫","轩辕","欧阳","东方","宇文","慕容"};
       System.out.println(strings.length());
        Random random=new Random();
        try {
            FileWriter fileWriter=new FileWriter("E:/name.txt",true);
            for (int i = 0; i < 1000000; i++) {
                 fileWriter.write(strings1[random.nextInt(strings1.length)] + strings.charAt(random.nextInt(strings.length()))+"\r\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

       // random.nextInt()
    }
}
