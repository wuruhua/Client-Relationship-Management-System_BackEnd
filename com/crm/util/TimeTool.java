package com.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 * 
 * 
 * 
 */
public class TimeTool {

	/**
	 * 将字符串类型转换为long类型
	 * 
	 * @param str要转换的字符串
	 * @return 转换后的字符串
	 */
	public static long parseLong(String str) {
		long ret = -1;
		try {
			ret = Long.parseLong(str);
		} catch (Exception e) {
			ret = -1;
		}
		return ret;
	}

	// 格式化
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 将字符串类型转换为Date类型
	 * 
	 * @param str要转换的字符串
	 * 
	 * @return 转换后的字符串
	 */
	public static Date parseDate(String str) {
		Date ret = null;
		try {
			ret = df.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 将Date类型转换为字符串类型
	 * 
	 * @param 要转换的Date
	 * @return 转换后的date
	 */
	public static String formatDate(Date date) {
		String ret = "?";
		try {
			ret = df.format(date);
		} catch (Exception e) {
			ret = "?";
		}
		return ret;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 当前时间
	 */
	public static String now() {
		return df.format(new Date());
	}
}
