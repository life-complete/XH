package com.aaa.fanshe;

import java.lang.reflect.Method;

public class Imp {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cla=Class.forName("com.aaa.fanshe.test");
        a aa=(a) cla.newInstance();
        aa.sal();
//           String a=new String("123");
//           String b="123";
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(a==b);
    }
}
