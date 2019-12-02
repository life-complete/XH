package com.sybercare.hospital.common.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
public class AndyLogger
{
    //The defaulted root path of SSLVPN installation
    private static String rootPath = "C:\\temp2";

    //variable for creating new line
    private final static String enter = System.getProperty("line.separator");

    private static SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static synchronized void log(String fileName, String logMessage)
    {
        try
        {
            File folder = new File(rootPath);
            if(!folder.exists())
            {
                folder.mkdir();
            }
            File file = new File(rootPath + "\\" + fileName + ".log");
            if(!file.exists())
            {
                file.createNewFile();
            }
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str = "";
            String strToal = "";

            while ((str = in.readLine()) != null)
            {
                strToal += (str + enter);
            }
            strToal = strToal + (sdf.format(new Date()) + " " + logMessage + enter);
            in.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(strToal);
            out.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static synchronized void log(String fileName, String[] logMessages)
    {
        try
        {
            File folder = new File(rootPath);
            if(!folder.exists())
            {
                folder.mkdir();
            }
            File file = new File(rootPath + "\\" + fileName + ".log");
            if(!file.exists())
            {
                file.createNewFile();
            }
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str = "";
            String strToal = "";

            while ((str = in.readLine()) != null)
            {
                strToal += (str + enter);
            }
            for (int i=0; i < logMessages.length ; i++)
            {
                String logMessage = logMessages[i];
                strToal = strToal + (sdf.format(new Date()) + " " + logMessage + enter);
            }
            in.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(strToal);
            out.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        AndyLogger.log("bug223", "timeisjjja");
        String[] logMessages = {"111","222","333"};
        AndyLogger.log("bug223", logMessages);
    }

}