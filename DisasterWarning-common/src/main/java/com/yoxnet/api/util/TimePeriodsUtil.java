package com.yoxnet.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 该类主要服务于sql中基于时间的统计查询，在写sql的过程中建议不要使用to_char或者to_date等oracle函数
 * 这样不利用索引（除非你对to_char进行了类似索引的操作
 * ），比如：在表的logintime字段上建立了索引，但是在sql中使用to_char(logintime,'yyyy-MM-dd')
 * 作为检索条件的时候，数据库在logintime上建立的索引就没用了。在数据量很大的时候会影响检索的速度。
 *  提供如下方法： 
 *  1、获取当前时间（按天截取时间）
 *  2、根据指定时间提供天、周、旬、月、季度、年的开始时间，结束时间（时间格式采java.util.Date）
 *  3、给定字符串类型的startTime和endTime，工具类负责类型的转换（String转换成Date） 
 *  注意：
 *  1、在sql中使用开始时间和最后时间的时候，为了保证统计数据的正确性，
 *    sql按给出的例子组织：t.logintime >= startTime and t.loginTime <= entTime 
 *  2、时间的字符串格式采用 yyyy-MM-dd
 * 
 */

public final class TimePeriodsUtil {

	private static SimpleDateFormat sDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static final int FIRSTTEN = 1 ;
	public static final int MIDTEN = 2;
	public static final int LASTTEN = 3;
	
	public static final int FIRSTQUARTER = 1;
	public static final int SECONDQUARTER = 2;
	public static final int THIRDQUARTER = 3;
	public static final int FORTHQUARTER = 4;
	
	private static Pattern pattern = Pattern
			.compile("^[1-9]\\d{3}-[01]?\\d-[0|1|2|3]?\\d$"); // 2010-12-22

	/**
	 * 获取当前系统时间按天截取的时间
	 * @return
	 */
	public static Date getSystemTranceDay(){
		return DateUtils.truncate(new Date(), Calendar.DATE);
	}
	
	/**
	 * 功能：根据指定时间获取当前天的开始和结束时间，以date数组返回
	 * 逻辑：
	 * 1、appointDate is null ,set default value sysdate
	 * 2、get date[]
	 * @param appointDate
	 * @return
	 */
	public static Date[] getDateArrByDay(Date appointDate){
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
		//未完
		if(appointDate == null){
			appointDate = new Date();
		}
		stime = DateUtils.truncate(appointDate,Calendar.DATE);
		etime = DateUtils.addSeconds(DateUtils.truncate(DateUtils.addDays(appointDate, 1), Calendar.DATE),-1);
		
		date[0] = stime;
		date[1] = etime;
		return date;
	}
	
	/**
	 * 功能：根据指定时间获取当前星期的开始和结束时间，以date数组返回
	 * @param appointDate
	 * @return
	 */
	public static Date[] getDateArrByWeek(Date appointDate){
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
		if(appointDate == null){
			appointDate = new Date();
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(appointDate);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		
		calendar.add(Calendar.DAY_OF_MONTH, -dayOfWeek+2);
		
		stime = DateUtils.truncate(calendar.getTime(), Calendar.DATE);
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		etime = DateUtils.addSeconds(DateUtils.truncate(calendar.getTime(), Calendar.DATE), -1);
		
		date[0] = stime;
		date[1] = etime;
		
		return date;
	}
	
	/**
	 * 功能：根据指定的时间和上中下旬的其中一个，获取开始时间和结束时间
	 * @param appointDate
	 * @param appointIndex
	 * @return
	 */
	public static Date[] getDateArrByTenDays(Date appointDate,int appointIndex ){
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
		if(appointDate == null){
			appointDate = new Date();
		}
		//init date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(appointDate);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int maxDayOfMonth = calendar.getMaximum(Calendar.DAY_OF_MONTH);
		
		Date tempDate = DateUtils.truncate(DateUtils.addDays(appointDate, -dayOfMonth + 1), Calendar.DATE);
		
		if(appointIndex == FIRSTTEN){
			stime = tempDate;
			etime = DateUtils.addSeconds(DateUtils.addDays(stime, 10), -1);
		}
		
		if(appointIndex == MIDTEN){
			stime = DateUtils.addDays(tempDate, 10);
			etime = DateUtils.addSeconds(DateUtils.addDays(stime, 10), -1);
		}
		
		if(appointIndex == LASTTEN){
			stime = DateUtils.addDays(tempDate, 20);
			etime = DateUtils.addSeconds(DateUtils.addDays(tempDate, maxDayOfMonth), -1);
		}
		
		date[0] = stime;
		date[1] = etime; 
		return date;
	}
	
	/**
	 * 功能:根据指定时间获取相应月份的开始时间和结束时间
	 * @param appointDate
	 * @return
	 */
	public static Date[] getDateArrByMonth(Date appointDate){
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
		if(appointDate == null){
			appointDate = new Date();
		}
		
		//init date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(appointDate);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int maxDayOfMonth = calendar.getMaximum(Calendar.DAY_OF_MONTH);
		
		appointDate = DateUtils.truncate(appointDate, Calendar.DATE);
		
		stime = DateUtils.truncate(DateUtils.addDays(appointDate, -dayOfMonth+1), Calendar.DATE);
		etime = DateUtils.addSeconds(DateUtils.addDays(stime, maxDayOfMonth), -1);
		
		date[0] = stime;
		date[1] = etime;
		
		return date;
	}
	
	/**
	 * 功能:获取当前时间的前几个月开始时间和结束（当前）时间
	 * @param monthCount(月数)
	 * @return
	 */
	public static Date[] getDateArrByBeforeMonthCount(Integer monthCount){
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
	      Calendar calendar = Calendar.getInstance();
	      //将calendar装换为Date类型
	      etime= calendar.getTime();
	  
	      //获取当前时间的前{monthCount}个月
	      if(null!=monthCount){
	    	  calendar.add(Calendar.MONTH,-monthCount);
		      stime = calendar.getTime(); 
	      }else{
	    	  //起始时间为一百年以前
	    	  calendar.add(Calendar.YEAR,-100);
		      stime = calendar.getTime(); 
	      }
	      
	      date[0] = stime;
	      date[1] = etime;
			
			return date;
		     
	}
	/**
	 * 功能：根据指定时间所在的当前年，获取指定季度的开始时间和结束时间
	 * @param appointDate 指定当前年
	 * @param appointIndex
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Date[] getDateArrByQuarter(Date appointDate,int appointIndex) throws IllegalArgumentException{
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
		if(appointDate == null){
			appointDate = new Date();
		}
		int month = appointDate.getMonth();
		Date tempDate = DateUtils.truncate(appointDate, Calendar.YEAR);
		if(appointIndex == FIRSTQUARTER){
			stime = tempDate;
		}else if(appointIndex == SECONDQUARTER){
			stime = DateUtils.addMonths(tempDate, 3);
		}else if(appointIndex == THIRDQUARTER ){
			stime = DateUtils.addMonths(tempDate, 6);
		}else if(appointIndex == FORTHQUARTER){
			stime = DateUtils.addMonths(tempDate, 9);
		}
		etime = DateUtils.addSeconds(DateUtils.addMonths(stime, 3), -1);
		
		date[0] = stime;
		date[1] = etime;
		
		return date;
	}
	
	/**
	 * 功能：根据指定时间，获取年的开始时间和结束时间
	 * @param appointDate
	 * @return
	 */
	public static Date[] getDateArrByYear(Date appointDate){
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
		if(appointDate == null){
			appointDate = new Date();
		}
		stime = DateUtils.truncate(appointDate, Calendar.YEAR);
		etime = DateUtils.addSeconds(DateUtils.addYears(stime, 1), -1);
		
		date[0] = stime;
		date[1] = etime;
		
		return date;
	}
	
	/**
	 * 逻辑： 1、检查startTime,endTime的有效性（是否为空，数据格式）， 异常处理: 1、两个参数都为空，抛出空指针异常
	 * 2、数据格式不对，直接抛出 3、一个参数为空，另一个参数格式正确的情况下，为空的参数采用系统时间，为了保证startTime <=
	 * endTime,工具类会做适当的调整 2、转换 3、返回值是个Date[2]数组，date[0] 保存startTime值,date[1]
	 * 保存startTime值，其中startTime <= endTime
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static Date[] convertDateClass(String startTime, String endTime)
			throws NullPointerException, DataFormatException, ParseException {
		Date stime = null;
		Date etime = null;
		Date[] date = new Date[2];
	
		if (StringUtils.isEmpty(startTime) && StringUtils.isEmpty(endTime)) {
			throw new NullPointerException("两个参数不能同时为空");
		}

		if (StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
			// 先判断endTime格式是否正确
			Matcher matcher = pattern.matcher(endTime);
			if (matcher.matches()) {
				stime = DateUtils.truncate(new Date(), Calendar.DATE); // 当天的开始时间，比如：当前时间为2010-12-27 11:31:30 这里stime的时间是2010-12-27 0:0:0
				etime = DateUtils.truncate(sDateFormat.parse(endTime),Calendar.DATE);
			} else {
				throw new DataFormatException(
						"参数endTime的格式不正确！正确的格式 yyyy-MM-dd 比如：2010-12-12！");
			}
		}
		if (!StringUtils.isEmpty(startTime) && StringUtils.isEmpty(endTime)) {
			Matcher matcher = pattern.matcher(startTime);
			if (matcher.matches()) {
				// 提供转换
				etime = DateUtils.truncate(new Date(), Calendar.DATE); // 当天的开始时间，比如：当前时间为2010-12-27 11:31:30 这里stime的时间是2010-12-27 0:0:0
				stime = DateUtils.truncate(sDateFormat.parse(startTime),Calendar.DATE);
			} else {
				throw new DataFormatException(
						"参数startTime的格式不正确！正确的格式 yyyy-MM-dd 比如：2010-12-12！");
			}
		}

		if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
			Matcher sMatcher = pattern.matcher(startTime);
			Matcher eMatcher = pattern.matcher(endTime);
			if (sMatcher.matches() && eMatcher.matches()) {

				stime = DateUtils.truncate(sDateFormat.parse(startTime),
						Calendar.DATE);
				etime = DateUtils.truncate(sDateFormat.parse(endTime),
						Calendar.DATE);

			} else {
				throw new DataFormatException(
						"请检查参数startTime、endTime的格式是否正确！正确的格式 yyyy-MM-dd 比如：2010-12-12！");
			}

		}

		if (!stime.before(etime)) {
			Date temp = stime;
			stime = etime;
			etime = temp;
			temp = null;
		}
		
		date[0] = stime;
		date[1] = etime;
		return date;
	}
}
