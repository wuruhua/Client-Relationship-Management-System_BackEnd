package com.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ��ת��������
 * 
 * 
 * 
 */
public class TimeTool {

	/**
	 * ���ַ�������ת��Ϊlong����
	 * 
	 * @param strҪת�����ַ���
	 * @return ת������ַ���
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

	// ��ʽ��
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * ���ַ�������ת��ΪDate����
	 * 
	 * @param strҪת�����ַ���
	 * 
	 * @return ת������ַ���
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
	 * ��Date����ת��Ϊ�ַ�������
	 * 
	 * @param Ҫת����Date
	 * @return ת�����date
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
	 * ��ȡ��ǰʱ��
	 * 
	 * @return ��ǰʱ��
	 */
	public static String now() {
		return df.format(new Date());
	}
}
