package com.study.example.leetcodestudy.util;

import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by L10002190 on 2016/10/29.
 */
public class DateUtil {

	public static final String FMT_DATE_HHMM = "HH:mm";

	public static final String FMT_UTC_1 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	public static final String FMT_UTC_2 = "yyyy-MM-dd'T'HH:mm:ssZ";

	public static final String FMT_DATE = "yyyy-MM-dd";
	public static final String FMT_DATE_1 = "yyyy/MM/dd";
	public static final String FMT_DATE_2 = "yyyy.MM.dd";
	public static final String FMT_DATE_3 = "yyyy-MM-dd HH:mm";
	public static final String FMT_DATE_4 = "HH:mm:ss";
	public static final String FMT_DATE_5 = "yyyy-MM-dd HH:mm:ss";
	public static final String FMT_DATE_6 = "MM月dd日 HH:mm";
	public static final String FMT_DATE_7 = "yyyy-MM-dd HH:mm:ss,SSS";
	public static final String FMT_DATE_8 = "yyyy年MM月dd日 HH:mm";
	public static final String FMT_DATE_9 = "yyyyMMddHHmmss";
	public static final String FMT_DATE_10 = "yyyy年MM月dd日";
	public static final String FMT_DATE_11 = "yyyy.MM.dd HH:mm";
	public static final String FMT_DATE_12 = "yyyy.MM";
	public static final String FMT_DATE_13 = "MM.dd";

	public static final int YEAR = Calendar.YEAR;
	public static final int MONTH = Calendar.MONTH;
	public static final int DAY = Calendar.DAY_OF_MONTH;

	private static final long MILLISECONDS_OF_SECOND = 1000;
	private static final long MILLISECONDS_OF_HOUR = 3600000; //60 * 60 * 1000
	private static final long MILLISECONDS_OF_DAY = 86400000; //24 * 60 * 60 * 1000

	public static String date2String(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (null == pattern) pattern = FMT_DATE_5;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date string2Date(String date) {
		Date resDate;
		resDate = string2Date(date, FMT_DATE_2);

		if (null == resDate) {
			resDate = string2Date(date, FMT_DATE_7);
		}
		if (null == resDate) {
			resDate = string2Date(date, FMT_DATE_8);
		}

		if (null == resDate) {
			resDate = string2Date(date, FMT_DATE_5);
		}

		if (null == resDate) {
			resDate = string2Date(date, FMT_DATE);
		}

		if (null == resDate) {
			resDate = string2Date(date, FMT_DATE_1);
		}

		return resDate;
	}

	private static Date string2Date(String date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			//ignore
		}
		return null;
	}

	/**
	 * 比较两个日期的年月日是否相等，即是否同一天
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean dateEquals(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		if (getDateVal(c1, YEAR) != getDateVal(c2, YEAR)) {
			return false;
		}
		if (getDateVal(c1, MONTH) != getDateVal(c2, MONTH)) {
			return false;
		}
		if (getDateVal(c1, DAY) != getDateVal(c2, DAY)) {
			return false;
		}
		return true;
	}

	public static int getDateVal(Calendar c, int field) {
		return c.get(field);
	}

	//UTC格式的时间转换为本地时间(+8小时是中国时间)
	public static Date utcToLoc(String utc) {
//		if (StringUtil.isEmpty(utc)) {
//			throw new IllegalArgumentException("utc is empty");
//		}
		String utcRep = utc.replace("Z", "UTC");
		return string2Date(utcRep, FMT_UTC_1);
	}

	public static Date addSecond(Date date, int seconds) {
		if (date == null) return null;
		return new Date(date.getTime() + MILLISECONDS_OF_SECOND * seconds);
	}

	public static Date addHour(Date date, int hours) {
		if (date == null) return null;
		return new Date(date.getTime() + MILLISECONDS_OF_HOUR * hours);
	}

	public static Date addDay(Date date, int days) {
		if (date == null) return null;
		return new Date(date.getTime() + MILLISECONDS_OF_DAY * days);
	}

	public static Date addYear(Date date, int years) {
		if (date == null) return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
	}

	public static Date addMonth(Date date, int amount) {
		if (date == null) return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, amount);
		return calendar.getTime();
	}

	public static LocalDate toLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 计算两个日期之间相差的天数 daysBetween("2012-09-08 10:10:10","2012-09-09 00:10:00");
	 * //1
	 *
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / MILLISECONDS_OF_DAY;

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 获取给定时间的起始时间
	 *
	 * @param calendarBefore
	 * @return
	 */
	public static Date getDayBegin(Calendar calendarBefore) {
		Calendar calendarAfter = Calendar.getInstance();
		calendarAfter.set(calendarBefore.get(Calendar.YEAR), calendarBefore.get(Calendar.MONTH),
				calendarBefore.get(Calendar.DATE));
		calendarAfter.set(Calendar.HOUR_OF_DAY, 0);
		calendarAfter.set(Calendar.MINUTE, 0);
		calendarAfter.set(Calendar.SECOND, 0);
		calendarAfter.set(Calendar.MILLISECOND, 0);
		return calendarAfter.getTime();
	}

	public static Date getDayBegin(Date date) {
		Calendar calendarBefore = Calendar.getInstance();
		calendarBefore.setTime(date);
		Calendar calendarAfter = Calendar.getInstance();
		calendarAfter.set(calendarBefore.get(Calendar.YEAR), calendarBefore.get(Calendar.MONTH),
				calendarBefore.get(Calendar.DATE));
		calendarAfter.set(Calendar.HOUR_OF_DAY, 0);
		calendarAfter.set(Calendar.MINUTE, 0);
		calendarAfter.set(Calendar.SECOND, 0);
		calendarAfter.set(Calendar.MILLISECOND, 0);
		return calendarAfter.getTime();
	}

	public static Date getDayBegin(LocalDate localDate) {
		LocalDateTime dateTime = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 00, 00, 00);
		return toDate(dateTime);
	}

	/**
	 * 获取给定时间的结束时间
	 *
	 * @param calendarBefore
	 * @return
	 */
	public static Date getDayEnd(Calendar calendarBefore) {
		Calendar calendarAfter = Calendar.getInstance();
		calendarAfter.set(calendarBefore.get(Calendar.YEAR), calendarBefore.get(Calendar.MONTH),
				calendarBefore.get(Calendar.DATE));
		calendarAfter.set(Calendar.HOUR_OF_DAY, 23);
		calendarAfter.set(Calendar.MINUTE, 59);
		calendarAfter.set(Calendar.SECOND, 59);
		calendarAfter.set(Calendar.MILLISECOND, 0);
		return calendarAfter.getTime();
	}

	public static Date getDayEnd(Date date) {
		Calendar calendarBefore = Calendar.getInstance();
		calendarBefore.setTime(date);
		Calendar calendarAfter = Calendar.getInstance();
		calendarAfter.set(calendarBefore.get(Calendar.YEAR), calendarBefore.get(Calendar.MONTH),
				calendarBefore.get(Calendar.DATE));
		calendarAfter.set(Calendar.HOUR_OF_DAY, 23);
		calendarAfter.set(Calendar.MINUTE, 59);
		calendarAfter.set(Calendar.SECOND, 59);
		calendarAfter.set(Calendar.MILLISECOND, 0);
		return calendarAfter.getTime();
	}

	/**
	 * 指定日期月第一天
	 * @param date
	 * @return
	 */
	public static Date getMonthBegin(Date date) {
		Calendar calendarBefore = Calendar.getInstance();
		calendarBefore.setTime(date);
		Calendar calendarAfter = Calendar.getInstance();
		calendarAfter.set(calendarBefore.get(Calendar.YEAR), calendarBefore.get(Calendar.MONTH), 1);
		calendarAfter.set(Calendar.HOUR_OF_DAY, 0);
		calendarAfter.set(Calendar.MINUTE, 0);
		calendarAfter.set(Calendar.SECOND, 0);
		calendarAfter.set(Calendar.MILLISECOND, 0);
		return calendarAfter.getTime();
	}

	/**
	 * 指定日期月最后一天
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar calendarBefore = Calendar.getInstance();
		calendarBefore.setTime(date);
		Calendar calendarAfter = Calendar.getInstance();
		calendarAfter.set(Calendar.YEAR, calendarBefore.get(Calendar.YEAR));
		calendarAfter.set(Calendar.MONTH, calendarBefore.get(Calendar.MONTH));
		calendarAfter.add(Calendar.MONTH, 1);
		calendarAfter.set(Calendar.DAY_OF_MONTH, 0);
		calendarAfter.set(Calendar.HOUR_OF_DAY, 23);
		calendarAfter.set(Calendar.MINUTE, 59);
		calendarAfter.set(Calendar.SECOND, 59);
		calendarAfter.set(Calendar.MILLISECOND, 0);
		return calendarAfter.getTime();
	}

	public static Date getDayEnd(LocalDate localDate) {
		LocalDateTime dateTime = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 23, 59, 59);
		return toDate(dateTime);
	}
	/**
	 * 获取传入日期的对应周的星期一的日期
	 *
	 * @param date
	 * @return
	 */
	public static Date getMondayDate(Date date) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int dayOfWeek = getDateVal(calendar, Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.MONDAY) {
			return calendar.getTime();
		}
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return calendar.getTime();
	}

	/**
	 * 获取传入日期的对应周的星期日的日期
	 *
	 * @param date
	 * @return
	 */
	public static Date getSundayDate(Date date) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int dayOfWeek = getDateVal(calendar, Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SUNDAY) {
			return calendar.getTime();
		}
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return calendar.getTime();
	}

	/**
	 * 按照显示的要求获取时间字符串
	 * 和当前时间比较，比如是今天则显示：“11:45”
	 * 昨天则显示：“昨天 11:45”，昨天以前显示格式：“yyyy-MM-dd HH:mm”
	 *
	 * @return
	 */
	public static String getDateShowStyle(Date date) throws Exception {
		// 获取给定时间的hhMMss
		String hhMM = date2String(date, FMT_DATE_HHMM);
		// 获取和当前时间之差
		int daysDiff = daysBetween(date, new Date());
		String showDay = null;
		switch (daysDiff) {
			case 0:
				showDay = hhMM;
				break;
			case 1:
				showDay = "昨天 " + hhMM;
				break;
			default:
				showDay = date2String(date, FMT_DATE_3);
				break;
		}
		return showDay;
	}

	/**
	 * 获取当年第一天的零点时刻,如 2017-01-01 00:00:00
	 *
	 * @return
	 */
	public static Date getEarliestDateTimeOfYear() {
		Integer thisYear = LocalDate.now().getYear();
		LocalDateTime dateTime = LocalDateTime.of(thisYear, 01, 01, 00, 00, 00);
		return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 获取指定日期的当月第几周,星期按周一开始、周日结束算
	 * @param date
	 * @return
	 */
	public static int getWeekOfMonth(Date date) {
		Assert.notNull(date, "date is null");

		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		//第几周
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	//是否小于等于今天
//	public static boolean isLessEqualToday(Date date) {
//		//date <= now
//		return date.compareTo(com.baj.sales.core.utils.DateUtil.getDayEnd(new Date())) < 1;
//	}

//	public static boolean isLessEqualToday(LocalDate localDate) {
//		Date date = com.baj.sales.core.utils.DateUtil.toDate(localDate);
//		return date.compareTo(com.baj.sales.core.utils.DateUtil.getDayEnd(new Date())) < 1;
//	}
	/**
	 * 获取当月第一天的最早时刻如2017-10-01 00:00:00
	 * @param localDate
	 * @return
	 */
	public static Date getEarliestTimeOfMonth(LocalDate localDate){
		Integer thisYear = localDate.getYear();
		Month month = localDate.getMonth();
		LocalDateTime dateTime = LocalDateTime.of(thisYear, month, 01, 00, 00, 00);
		return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
	}


	/**
	 * 获取当月最后一天的最晚时刻如2017-10-31 23:59:59
	 * @param localDate
	 * @return
	 */
	public static Date getLastTimeOfMonth(LocalDate localDate){
		LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
		LocalDateTime dateTime = LocalDateTime.of(lastDay.getYear(), lastDay.getMonth(), lastDay.getDayOfMonth(), 23, 59, 59);
		return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
}
