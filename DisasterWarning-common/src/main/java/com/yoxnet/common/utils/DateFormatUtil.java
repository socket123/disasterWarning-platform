package com.yoxnet.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/** 
 * 日期格式转换工具类 
 */
public class DateFormatUtil {
	
	
	private static String datePattern = "MM/dd/yyyy";
	
	public static final String DATE_YEAR_MONTH_FORMAT = "yyyyMM";

    public static final String MONTH_FORMAT = "yyyy-MM";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_FORMAT2 = "yyyy/MM/dd HH:mm:ss";


    public static final String DATEFORMAT = "yyyyMMdd";

    public static final String DATEFORMAT_YYMMDD = "yyMMdd";


    public static final String TIME_FORMAT = "yyyyMMddHHmmss";

    public static final String TIME_FORMAT_YY = "yyMMddHHmmss";

	/**
	 * 将指定字符串转换成日期
	 * @param date 
	 * 			String 日期字符串
	 * @param datePattern
	 * 			String 日期格式
	 * @return Date
	 */
	public static Date getFormatDate(String date,String datePattern){
		 SimpleDateFormat sd = new SimpleDateFormat(datePattern);
		return sd.parse(date, new ParsePosition(0));
	}
	
	/**
	 * 将指定日期对象转换成格式化字符串
	 * @param date
	 * 			Date 日期对象
	 * @param datePattern
	 * 			String 日期格式
	 * @return
	 */
	public static String getFormattedString(Date date, String datePattern) {
		SimpleDateFormat sd = new SimpleDateFormat(datePattern);
		return sd.format(date);
	}
	
    /** 
     * @param 含有yyyy-MM-dd'T'hh:mm:ss.SSS格式的时间转换. 
     * @return 
     */  
    public static String getTFormatString(String tdate) {  
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");  
        String str ="";  
        try {  
            java.util.Date date = format1.parse(tdate);  
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
             str = format2.format(date);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return str;  
    }
    /** 
     * 获得当前时间，格式yyyy-MM-dd hh:mm:ss 
     *  
     * @param format 
     * @return 
     */ 
    public static String getCurrentDateTime() {  
        return getCurrentDate("yyyy-MM-dd HH:mm:ss");  
    }  
    /** 
     * 获得当前时间，格式自定义 
     *  
     * @param format 
     * @return 
     */ 
    public static String getCurrentDate(String format) {  
        Calendar day = Calendar.getInstance();  
        day.add(Calendar.DATE, 0);  
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"  
        String date = sdf.format(day.getTime());  
        return date;  
    }
    /** 
     * @param date1 
     *            需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12 
     * @param date2 
     *            被比较的时间 为空(null)则为当前时间 
     * @param stype 
     *            返回值类型 0为多少天，1为多少个月，2为多少年 
     * @return 举例： compareDate("2009-09-12", null, 0);//比较天 
     *         compareDate("2009-09-12", null, 1);//比较月 
     *         compareDate("2009-09-12", null, 2);//比较年 
     */ 
    public static int compareDate(String startDay, String endDay, int stype) {  
        int n = 0;  
        String[] u = { "天", "月", "年" };  
        String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";  
   
        endDay = endDay == null ? getCurrentDate("yyyy-MM-dd") : endDay;  
   
        DateFormat df = new SimpleDateFormat(formatStyle);  
        Calendar c1 = Calendar.getInstance();  
        Calendar c2 = Calendar.getInstance();  
        try {  
            c1.setTime(df.parse(startDay));  
            c2.setTime(df.parse(endDay));  
        } catch (Exception e3) {  
            System.out.println("wrong occured");  
        }  
        // List list = new ArrayList();  
        while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果  
            // list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来  
            n++;  
            if (stype == 1) {  
                c1.add(Calendar.MONTH, 1); // 比较月份，月份+1  
            } else {  
                c1.add(Calendar.DATE, 1); // 比较天数，日期+1  
            }  
        }  
        n = n - 1;  
        if (stype == 2) {  
            n = (int) n / 365;  
        }  
        // System.out.println(startDay+" -- "+endDay+" 相差多少"+u[stype]+":"+n);  
        return n;  
    }
    /** 
     * 判断时间是否符合时间格式 
     */ 
    public static boolean isLegalDateString(String date, String dateFormat) {  
        if (date != null) {  
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(  
                    dateFormat);  
            format.setLenient(false);  
            try {  
                format.format(format.parse(date));  
            } catch (ParseException e) {  
                return false;  
            }  
            return true;  
        }  
        return false;  
    }
    /** 
     * 数值型的时间改为字符串型时间 
     *  
     * @param time 
     * @return 
     */ 
    public static String getTime(long time) {  
        try {  
            Date date = new Date(time);  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//    
            String strdate = sdf.format(date);  
            return strdate;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return "0";  
        }  
    }  
       
    /** 
     * 传入"yyyy-MM-dd HH:mm:ss"格式字符串,传出从1970 年~~~  至dateString表示时刻之间的ms。 
     * @return 
     */ 
    public static long getTimeMillis(String dateString){  
        long timeMillis = 0;  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        try {  
            Date date= sdf.parse(dateString);  
            timeMillis = date.getTime();  
        } catch (ParseException e) {  
        }  
        return timeMillis;  
    }
    /** 
     * 获得后N天的时间，格式自定义 
     *  
     * @param format 
     * @return 
     */ 
    public static String getDelayDayDate(String format,int delay) {  
        Calendar day = Calendar.getInstance();  
        day.add(Calendar.DATE, delay);  
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"  
        String date = sdf.format(day.getTime());  
        return date;  
    }  
       
    /** 
     * 获得后N小时的时间，格式自定义 
     * @param format 
     * @param delay 
     * @return 
     */ 
    public static String getDelayHourDate(String format,int delay){  
        Calendar day = Calendar.getInstance();  
        day.add(Calendar.HOUR, delay);  
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"  
        String date = sdf.format(day.getTime());  
        return date;  
    }  
       
    /** 
     * @param date1 
     *            需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12 16:24 
     * @param date2 
     *            被比较的时间 为空(null)则为当前时间 
     * @param stype 0为比较小时，1为比较分钟。 
     * @return  
     */ 
    public static int compareTime(String startDay, String endDay,int stype) {  
        int n = 0;  
        String formatStyle = "yyyy-MM-dd HH:mm";  
   
        endDay = endDay == null ? getCurrentDate("yyyy-MM-dd HH:mm") : endDay;  
   
        DateFormat df = new SimpleDateFormat(formatStyle);  
        Calendar c1 = Calendar.getInstance();  
        Calendar c2 = Calendar.getInstance();  
        try {  
            c1.setTime(df.parse(startDay));  
            c2.setTime(df.parse(endDay));  
        } catch (Exception e3) {  
            System.out.println("wrong occured");  
        }  
        // List list = new ArrayList();  
        while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果  
            // list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来  
            n++;  
            if(stype == 0){  
                c1.add(Calendar.HOUR, 1); // 比较月份，月份+1  
            }else{  
                c1.add(Calendar.MINUTE, 1); // 比较月份，月份+1  
            }  
        }  
        n = n - 1;  
        return n;  
    }
    
	/**
	 *得到格式化后的系统当前日期
	 *@param strScheme 格式模式字符串
	 *@return 格式化后的系统当前时间，如果有异常产生，返回空串""
	 *@see java.util.SimpleDateFormat
	 */
	public static final String getNowDateTime(String strScheme) {
		String strReturn = null;
		Date now = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(strScheme);
			strReturn = sdf.format(now);
		} catch (Exception e) {
			strReturn = "";
		}
		return strReturn;
	}
	
	 public static Date toBeginDate(Date beginDate) {
	        if (beginDate == null ) {
	            return null;
	        }
	        Calendar cal= Calendar.getInstance();
	        cal.setTime(beginDate);
	        cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
	        return cal.getTime();
	  }

	  public static Date toEndDate(Date endDate) {
		  if (endDate == null ) {
	            return null;
	        }
	        Calendar cal= Calendar.getInstance();
	        cal.setTime(endDate);
	        cal.set(Calendar.HOUR_OF_DAY,23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
	        return cal.getTime();
	    }
	
	  public static void main(String[] args) {
	    	Date d=DateFormatUtil.toEndDate(new Date());
	    	System.out.println(DateFormatUtil.getFormattedString(d, DATETIME_FORMAT));
	    	
	    } 
	  
}
