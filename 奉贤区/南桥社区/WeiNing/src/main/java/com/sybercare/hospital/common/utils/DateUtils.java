package com.sybercare.hospital.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {

    private static String delimiter = "-";// 分隔字符

    /**
     * 获取当前日期/时间 根据类型格式化字符串
     *
     * @author Xuwb
     * @since 2010.10.22
     *
     * @param type日期格式相应的参数
     *
     * @return 格式化后日期字符串
     */
    public static String getCurrent(int type) {
        return new SimpleDateFormat(getPattern(type)).format(new Date());
    }

    /**
     * XMLGregorianCalendar与Date 转换
     *
     * @param date
     * @return
     * @throws DatatypeConfigurationException
     */
    public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {

        GregorianCalendar cal = new GregorianCalendar();
        XMLGregorianCalendar gc = null;
        try {
            cal.setTime(date);
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            throw new DatatypeConfigurationException("日期转换异常");
        }
        return gc;
    }

    /**
     * XMLGregorianCalendar与Date 转换
     *
     * @param cal
     * @return
     * @throws Exception
     */
    public static Date convertToDate(XMLGregorianCalendar cal) throws Exception {

        GregorianCalendar ca = cal.toGregorianCalendar();
        return ca.getTime();

    }

    /**
     * 把指定时间按指定格式为字符串
     *
     * @author Xuwb
     * @since 2010.10.22
     *
     * @param date日期
     * @param type日期格式相应的参数
     *
     * @return 格式化后日期字符串
     */
    public static String fmtDate(Date date, int type) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(getPattern(type)).format(date);
    }

    /**
     * 把时间格式字符串，转化为Date类型
     *
     * @author Xuwb
     * @since 2010.11.29
     *
     * @param strDate日期格式字符串
     * @param type日期格式相应的参数
     *
     * @return 格式化后日期字符串
     * */
    public static Date parse(String strDate, int type) throws UserException {
        try {
            return new SimpleDateFormat(getPattern(type)).parse(strDate);
        } catch (Exception e) {
            throw new UserException(11, 7, "DateUtils.parse()", strDate + "字符串转化指定格式日期失败！");
        }
    }

    public static boolean isValidTime(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    public static boolean isValidDateYM(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * @Title: isValidDateYMD
     * @author wangzhi
     * @Description: 判断时间是否是yyyy-MM-dd格式
     * @param @param str
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     */
    public static boolean isValidDateYMD(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    public static String getFourthMin(String time) {
        String nextTime = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Calendar c = Calendar.getInstance();
            Date d0 = (Date) format.parseObject(time);
            c.setTime(d0);
            c.add(Calendar.MINUTE, 4);
            nextTime = format.format(c.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nextTime;
    }

    /**
     * 计算出两个日期的间隔的天数<br/>
     * 如：<br/>
     * startDate = 2010-2-1, endDate = 2010-2-11<br/>
     * 则返回10<br/>
     * startDate应该小于等于endDate, 否则返回的天数是负值
     *
     * @author ZhangHongyang
     * @date 2010-12-2
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long betweenDays(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 计算出两个日期的间隔的月数(不足一月的按一月)<br/>
     * 如：<br/>
     * startDate = 2010-10-11, endDate = 2011-1-6<br/>
     * 则返回3<br/>
     * startDate应该小于等于endDate, 否则返回-10000
     *
     * @author Xuwb
     * @date 2011.10.15
     * @param startDate
     * @param endDate
     * @return
     */
    public static int betweenMonths(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        endCalendar.set(Calendar.HOUR_OF_DAY, 0);
        endCalendar.set(Calendar.MINUTE, 0);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);
        int back = 0;
        if (startCalendar.compareTo(endCalendar) == -1) {
            int years = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
            int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
            int days = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
            back = years * 12 + month;
            if (days >= 0) {
                back += 1;
            }
        } else if (startCalendar.compareTo(endCalendar) == 0) {
            back = 1;
        } else {
            back = -10000;
        }
        return back;
    }

    /**
     * 计算出两个日期的间隔的月数(不足一月的按一月) 如：startDate = 2010-10-11, endDate = 2011-10-15 则返回13; startDate应该小于等于endDate, 否则返回-10000;
     * 传入的字符串日期格式须为：yyyy-MM-dd, 否则返回-99999
     *
     * @author Xuwb
     * @date 2011.10.15
     * @param startDate
     * @param endDate
     * @return
     */
    public static int betweenMonths(String startDate, String endDate) {
        int back = 0;
        try {
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(DateUtils.parse(startDate, 13));
            startCalendar.set(Calendar.HOUR_OF_DAY, 0);
            startCalendar.set(Calendar.MINUTE, 0);
            startCalendar.set(Calendar.SECOND, 0);
            startCalendar.set(Calendar.MILLISECOND, 0);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(DateUtils.parse(endDate, 13));
            endCalendar.set(Calendar.HOUR_OF_DAY, 0);
            endCalendar.set(Calendar.MINUTE, 0);
            endCalendar.set(Calendar.SECOND, 0);
            endCalendar.set(Calendar.MILLISECOND, 0);
            if (startCalendar.compareTo(endCalendar) == -1) {
                int years = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
                int days = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
                back = years * 12 + month;
                if (days > 0) {
                    back += 1;
                }
            } else if (startCalendar.compareTo(endCalendar) == 0) {
                back = 0;
            } else {
                back = -10000;
            }
        } catch (UserException e) {
            back = -99999;
        }
        return back;
    }

    /**
     * 把日期增加指定的天数
     *
     * @author Xuwb
     * @since 2010.12.28
     *
     * @param strDate日期格式字符串
     * @param days天数
     *
     * @return 增加天数后的日期
     */
    public static Date addDays(Date date, int days) throws UserException {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(date);
            calendar.add(Calendar.DATE, days);
            return calendar.getTime();
        } catch (Exception e) {
            throw new UserException(11, 9, "DateUtils.parse()", "把日期增加指定的天数失败！");
        }
    }

    /**
     * 把日期增加指定的天数
     *
     * @author Xuwb
     * @since 2010.12.28
     *
     * @param strDate日期格式字符串
     * @param days天数
     * @param type日期格式相应的参数
     *
     * @return 增加天数后的并按指定格式格式化后日期字符串
     */
    public static String addDays(Date date, int days, int type) throws UserException {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(date);
            calendar.add(Calendar.DATE, days);
            return new SimpleDateFormat(getPattern(type)).format(calendar.getTime());
        } catch (Exception e) {
            throw new UserException(11, 9, "DateUtils.parse()", "把日期增加指定的天数失败！");
        }
    }

    /**
     * 功能：比较日期是否相等
     *
     * @param FirstDate String 输入为yyyy-MM-DD或者yyyy/MM/DD
     * @param SecondDate String
     * @return int 1：大于，0：相等，-1：小于
     */
    public static int compareDate(String FirstDate, String SecondDate) throws Exception {
        int intReturn = 0; // 返回值
        java.util.Date firstDate = null;
        java.util.Date secondDate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            firstDate = format.parse(FirstDate);
            secondDate = format.parse(SecondDate);
            if (firstDate.after(secondDate)) {
                intReturn = 1;
            } else if (firstDate.before(secondDate)) {
                intReturn = -1;
            } else if (firstDate.equals(secondDate)) {
                intReturn = 0;
            }
            return intReturn;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getUpMonth(String currentMonth) {
        String upMonth = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            Calendar c = Calendar.getInstance();
            Date d0 = (Date) format.parseObject(currentMonth);
            c.setTime(d0);
            c.add(Calendar.MONTH, -1);
            upMonth = format.format(c.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return upMonth;
    }

    //功能：比较两个时间差，毫秒
    public static Long diffTime(String FirstTime, String SecondTime) throws Exception {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Long diff = sd.parse(SecondTime).getTime() - sd.parse(FirstTime).getTime();
            return diff;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String getPattern(int type) {

        String pattern = null;

        switch (type) {
            case 9:
                pattern = "yyyyMMdd";
                break;
            case 11:
                pattern = "yyyy";
                break;
            case 12:
                pattern = "yyyy" + delimiter + "MM";
                break;
            case 13:
                pattern = "yyyy" + delimiter + "MM" + delimiter + "dd";
                break;
            case 14:
                pattern = "yyyy" + delimiter + "MM" + delimiter + "dd HH";
                break;
            case 15:
                pattern = "yyyy" + delimiter + "MM" + delimiter + "dd HH:mm";
                break;
            case 16:
                pattern = "yyyy" + delimiter + "MM" + delimiter + "dd HH:mm:ss";
                break;
            case 22:
                pattern = "MM";
                break;
            case 23:
                pattern = "MM" + delimiter + "dd";
                break;
            case 24:
                pattern = "MM" + delimiter + "dd HH";
                break;
            case 25:
                pattern = "MM" + delimiter + "dd HH:mm";
                break;
            case 26:
                pattern = "MM" + delimiter + "dd HH:mm:ss";
                break;
            case 27:
                pattern = "MM" + delimiter + "dd HH:mm:ss.SSS";
                break;
            case 33:
                pattern = "dd";
                break;
            case 34:
                pattern = "dd HH";
                break;
            case 35:
                pattern = "dd HH:mm";
                break;
            case 36:
                pattern = "dd HH:mm:ss";
                break;
            case 37:
                pattern = "dd HH:mm:ss.SSS";
                break;
            case 44:
                pattern = "HH";
                break;
            case 45:
                pattern = "HH:mm";
                break;
            case 46:
                pattern = "HH:mm:ss";
                break;
            case 47:
                pattern = "HH:mm:ss.SSS";
                break;
            case 55:
                pattern = "mm";
                break;
            case 56:
                pattern = "mm:ss";
                break;
            case 57:
                pattern = "mm:ss.SSS";
                break;
            case 66:
                pattern = "ss";
                break;
            case 67:
                pattern = "ss.SSS";
                break;
            case 77:
                pattern = "SSS";
            case 78:
                pattern = "yyyyMMddHHmmss";
                break;
            case 79://GMT
                pattern = "EEE, yyyy-MMM-dd HH:mm:ss z";
                break;
            default:
                throw new IllegalArgumentException(type + " is not support!");
        }

        return pattern;
    }

    public static String getWeekOfDate(Date date) {
        //String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        String[] weekDaysCode = { "7", "1", "2", "3", "4", "5", "6" };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDaysCode[intWeek];
    }

    private static void setDelimiter(String delimiter) {
        DateUtils.delimiter = delimiter;
    }

    /**
     * 根据日期获得该日期是几号
     *
     * @param date
     * @return
     */
    public static int getMonchOfDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String dateString = formatter.format(date);
        int intDay = Integer.parseInt(dateString);
        return intDay;
    }

    /**
     * 根据日期获得该日期是几号
     *
     * @param date
     * @return 如果是06号则返回的是6
     */
    public static String getMonchOfDateStr(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String dateString = formatter.format(date);
        int intDay = Integer.parseInt(dateString);
        //防止出现闰月
        if (intDay > 28) {
            intDay = 28;
        }
        return String.valueOf(intDay);
    }

    /**
     *
     * @Description:在指定时间上加上分钟
     * @param @param date 日期
     * @param @param interval 分钟数
     * @param @return
     * @return String
     * @throws
     * @author shexinyi
     * @date 2016-4-18
     */
    public static String getAddTime(Date date, Integer interval) {
        SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 这里的格式可以自己设置
        //String times = from.format(date);
        //原始时间
        // System.out.println("原始时间："+times);
        date.setMinutes(date.getMinutes() + interval);//给当前时间加50分钟后的时间
        String times = from.format(date);
        // System.out.println("相加之后的时间："+times);
        return times;
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     *Fri Jul 27 10:55:00 CST 2018
     * 标准化时间显示
     * yyyy-MM-dd HH:mm:ss
     * @param dateStr
     * @return
     */
    public static String formatDate1(String dateStr) {
        String[] aStrings = dateStr.split(" ");
        // 5
        if (aStrings[1].equals("Jan")) {
            aStrings[1] = "01";
        }
        if (aStrings[1].equals("Feb")) {
            aStrings[1] = "02";
        }
        if (aStrings[1].equals("Mar")) {
            aStrings[1] = "03";
        }
        if (aStrings[1].equals("Apr")) {
            aStrings[1] = "04";
        }
        if (aStrings[1].equals("May")) {
            aStrings[1] = "05";
        }
        if (aStrings[1].equals("Jun")) {
            aStrings[1] = "06";
        }
        if (aStrings[1].equals("Jul")) {
            aStrings[1] = "07";
        }
        if (aStrings[1].equals("Aug")) {
            aStrings[1] = "08";
        }
        if (aStrings[1].equals("Sep")) {
            aStrings[1] = "09";
        }
        if (aStrings[1].equals("Oct")) {
            aStrings[1] = "10";
        }
        if (aStrings[1].equals("Nov")) {
            aStrings[1] = "11";
        }
        if (aStrings[1].equals("Dec")) {
            aStrings[1] = "12";
        }
        return aStrings[5] + "-" + aStrings[1] + "-" + aStrings[2] + " " + aStrings[3];
    }

    /**

     *格式化为date类型的

     */

    public static Date formatDate2(String dateStr) {
        String[] aStrings = dateStr.split(" ");
        // 5
        if (aStrings[1].equals("Jan")) {
            aStrings[1] = "01";
        }
        if (aStrings[1].equals("Feb")) {
            aStrings[1] = "02";
        }
        if (aStrings[1].equals("Mar")) {
            aStrings[1] = "03";
        }
        if (aStrings[1].equals("Apr")) {
            aStrings[1] = "04";
        }
        if (aStrings[1].equals("May")) {
            aStrings[1] = "05";
        }
        if (aStrings[1].equals("Jun")) {
            aStrings[1] = "06";
        }
        if (aStrings[1].equals("Jul")) {
            aStrings[1] = "07";
        }
        if (aStrings[1].equals("Aug")) {
            aStrings[1] = "08";
        }
        if (aStrings[1].equals("Sep")) {
            aStrings[1] = "09";
        }
        if (aStrings[1].equals("Oct")) {
            aStrings[1] = "10";
        }
        if (aStrings[1].equals("Nov")) {
            aStrings[1] = "11";
        }
        if (aStrings[1].equals("Dec")) {
            aStrings[1] = "12";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = aStrings[5] + "-" + aStrings[1] + "-" + aStrings[2] + " " + aStrings[3];
        Date datetime = null;
        try {
            datetime = df.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return datetime;
    }
}
