package com.crm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5���ܹ�����
 * 
 * 
 * 
 */
public final class MD5Util {
	/**
	 * ���ܷ���:md5���ڵ�����ܣ�������ģ����磺�ü��ܺ���ַ����ٽ��м��ܣ��������ͼ���ǰ��һ��
	 * 
	 * @param s
	 *            Ҫ���ܵ��ַ���
	 * @return ���ܺ���ַ���
	 */
	public static final String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		byte[] btInput = s.getBytes();
		try {
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("û�к��ʵļ��ܷ���");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
