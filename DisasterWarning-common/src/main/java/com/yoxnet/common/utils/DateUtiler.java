package com.yoxnet.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * <strong>Title : DateUtiler </strong>. <br>
 * <strong>Description : 日期工具类 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期.</strong> <br>
 * <strong>Create on : Jun 11, 2015 5:51:59 PM </strong>. <br>
 * <p>
 * <strong>Copyright (C) AlexHo Co.,Ltd.</strong> <br>
 * </p>
 * 
 * @author k2 hechs@yoxnet.com <br>
 * @version <strong>zhpgo-0.0.1</strong> <br>
 * <br>
 *          <strong>修改历史: .</strong> <br>
 *          修改人 修改日期 修改描述<br>
 *          -------------------------------------------<br>
 * <br>
 * <br>
 */
public final class DateUtiler {
	
	public static final String ENG_DATE_FROMAT = "EEE, d MMM yyyy HH:mm:ss z";  
	public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.S";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";  
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";  
   
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";  
    public static final String DD = "dd";  
	
    public static final String YYYY_MM_DD_CN = "yyyy年MM月dd";
    public static final String YYYY_MM_DD_HH_MM_SS_CN = "yyyy年MM月dd日  HH时mm分ss秒";
	public static final String YYYY_MM_DD_HH_MM_SS_S_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";
	

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 获得默认的 date pattern.
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDefaultPattern() {
		return YYYY_MM_DD_HH_MM_SS;
	}

	
	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 根据预设格式返回当前日期.
	 * @return 默认的 yyyy-MM-dd HH:mm:ss
	 */
	public static String getNow() {
		return format(new Date());
	}


	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 根据用户格式返回当前日期.
	 * @param format
	 * @return
	 */
	public static String getNow(String format) {
		return format(new Date(), format);
	}


	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 使用预设格式将字符串日期转换成日期类型的对象.
	 * @param strDate 2015-06-24 18:06:19
	 * @return
	 */
	public static Date format(String strDate) {
		return format(strDate, getDefaultPattern());
	}

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 使用用户格式将字符串日期转换成日期类型的对象.
	 * @param strDate 2015-06-24 18:06:19 993
	 * @param pattern
	 * @return
	 */
	public static Date format(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 使用预设的默认格式,将日期类型的对象转换成字符串类型格式.
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, getDefaultPattern());
	}

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 使用用户指定格式，将日期类型的对象转换成字符串类型日期.
	 * @param date 
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}

	/**
	 * @author by k2 Jun 18, 2015
	 *
	 * @desc 在日期上增加减少时间，如数个整月、天、小时、分钟. 
	 * @param date
	 * @param timeUnit e.g Calendar.YEAR,Calendar.MONTH, Calendar.HOUR ...
	 * @param n 如： 增加3个月 n=3；减3个月 n=-3
	 * @return
	 */
	public static Date addTimeByUnit(Date date, int timeUnit, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(timeUnit, n);
		return cal.getTime();
	}

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 获取时间戳.
	 * @return e.g 2015-08-13 14:30:13.893
	 */
	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_S);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}
	
	

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 获取日期年份.
	 * @param date
	 * @return e.g 2015
	 */
	public static String getYear(Date date) {
		return format(date).substring(0, 4);
	}
	
	/**
	 * @author guyang
	 * 
	 * @desc 获取日期月份.
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date){
		return format(date).substring(5,7);
	}

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 按默认格式的字符串距离今天的天数.
	 * @param date 2015-06-24 18:06:19 993
	 * @return
	 */
	public static int countDays(String date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(format(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 按用户格式字符串距离今天的天数.
	 * @param date 2015-06-24 18:06:19 993
	 * @param format
	 * @return
	 */
	public static int countDays(String date, String format) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(format(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}
	
	
	
	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 字符串转换成时间对象 .
	 * @param dateString 2015-06-24 18:06:19 993
	 * @param formatStr
	 * @return
	 */
	public static Date string2date(String dateString, String formatStr) {
		Date formateDate = null;
		DateFormat format = new SimpleDateFormat(formatStr);
		try {
			formateDate = format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
		return formateDate;
	}

	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc 当前时间毫秒转化成10位数字串.
	 * @return 1439447678
	 */
	public static String date2timeMillis() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
  
    
	/**
	 * @author by k2 Jun 11, 2015
	 *
	 * @desc Date类型转换为Timestamp类型 .
	 * @param date
	 * @return 
	 */
	public static Timestamp date2timestamp(Date date) {
		if (date == null)
			return null;
		return new Timestamp(date.getTime());
	}
    
    /**
     * @author by k2 Jun 25, 2015
     *
     * @desc 时间毫秒数转换成指定日期格式.
     * @param time
     * @param formatStr
     * @return
     */
    public static String timeMillis2dateString(Long time, String formatStr){
		Date d = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(d);
	}
    
    /**
     * @author by k2 Jun 11, 2015
     *
     * @desc sql时间对象转换成字符串 .
     * @param timestamp
     * @param formatStr
     * @return
     */
    public static String timestamp2string(Timestamp timestamp, String formatStr) {  
        String strDate = "";  
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);  
        strDate = sdf.format(timestamp);  
        return strDate;  
    }  
  
    /**
     * @author by k2 Jun 11, 2015
     *
     * @desc 指定时间距离当前时间的中文信息 .
     * @param time
     * @return
     */
    public static String getLnow(long time) {  
        Calendar cal = Calendar.getInstance();  
        long timel = cal.getTimeInMillis() - time;  
        if (timel / 1000 < 60) {  
            return "1分钟以内";  
        } else if (timel / 1000 / 60 < 60) {  
            return timel / 1000 / 60 + "分钟前";  
        } else if (timel / 1000 / 60 / 60 < 24) {  
            return timel / 1000 / 60 / 60 + "小时前";  
        } else {  
            return timel / 1000 / 60 / 60 / 24 + "天前";  
        }  
    }
    
    /**
     * @author by K2 Aug 21, 2015
     *
     * @desc 检查时间前后逻辑是否有序.
     * @param time1
     * @param time2
     * @return
     */
    public static boolean chkIsCorrect(String time1, String time2) {
    	if(Stringer.isNullOrEmpty(time1) || Stringer.isNullOrEmpty(time2)){
    		return false;
    	} else if(time1.equals(time2)) {
    		return true;
    	}
		Date begin = string2date(time1,getDefaultPattern());
		Date end = string2date(time2,getDefaultPattern());
		return begin.before(end);
		
	}
    
    
    /**
    * @Description: 两个日期相差天数
    * @param smdate
    * @param bdate
    * @return
    * @throws ParseException
    * @author: Aaron
    * @date: 2016年10月18日 下午2:45:59
    */
    public static int daysBetween(String smdate,String bdate) {  
        SimpleDateFormat sdf=new SimpleDateFormat(YYYY_MM_DD);  
        Calendar cal = Calendar.getInstance();    
        try {
			cal.setTime(sdf.parse(smdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}    
        long time1 = cal.getTimeInMillis();                 
        try {
			cal.setTime(sdf.parse(bdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }  
    
    
    /**
    * @Description: 两个时间相差时/分
    * @param str1
    * @param str2
    * @return
    * @author: Aaron
    * @date: 2016年10月18日 下午3:29:07
    */
    public static int getDistanceTime(String str1, String str2,String str) {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date one;  
        Date two;  
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        long sec = 0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            day = diff / (24 * 60 * 60 * 1000);  
            hour = (diff / (60 * 60 * 1000) - day * 24);  
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        if(str.equals("h")){
        	return (int)hour;
        }else if(str.equals("m")){
        	return (int)min;  
        }else{
        	return (int)sec;  
        }
    }  
    
    
    /**
    * @Description: 相差天,小时,分,秒
    * @param str1
    * @param str2
    * @return
    * @author: Aaron
    * @date: 2016年10月21日 下午2:42:28
    */
    public static String getDistanceTime(String str1, String str2) {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date one;  
        Date two;  
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        long sec = 0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            day = diff / (24 * 60 * 60 * 1000);  
            hour = (diff / (60 * 60 * 1000) - day * 24);  
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return day + "天" + hour + "小时" + min + "分" + sec + "秒";  
    }  
    
    public static int dateCompareTo(String firstDate,String lastDate){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date firstDate1;
		Date lastDate1;
		int i = 0;
		try {
			firstDate1 = dateFormat.parse(firstDate);
			lastDate1 = dateFormat.parse(lastDate);
			i = firstDate1.compareTo(lastDate1); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
    
    /**
     * 判断当前日期是星期几,如果不传参数则返回当前星期几
     * 
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
	 public static int dayForWeek(String date) throws Exception {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar c = Calendar.getInstance();
	    if(!Stringer.isNullOrEmpty(date)){
	    	c.setTime(format.parse(date));
	    }
	    int dayForWeek = 0;
	    if(c.get(Calendar.DAY_OF_WEEK) == 1){
	      dayForWeek = 7;
	    }else{
	      dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
	    }
	    return dayForWeek;
	 }
    
    
    public static void main(String[] args) {
    	 System.out.println(dateCompareTo("2016-10-20 10:10:10","2016-10-19 11:10:10"));  
	}
    
}