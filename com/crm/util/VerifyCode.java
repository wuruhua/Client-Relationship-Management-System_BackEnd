package com.crm.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * ��֤�����ɸ�����
 * @author Fiona
 * 
 * 
 */
public class VerifyCode {
	static Random r = new Random();
	static String ssource = "ABCDEFGHJKLMNPQRSTUVWXYZ"
			+ "abcdefghjkmnpqrstuvwxyz" + "23456789";
	static char[] src = ssource.toCharArray();

	/**
	 * ��������ַ���
	 * 
	 * @param length
	 *            ����ַ����ĳ���
	 * @return ����ַ���
	 */
	private static String randString(int length) {
		char[] buf = new char[length];
		int rnd;
		for (int i = 0; i < length; i++) {
			rnd = Math.abs(r.nextInt()) % src.length;
			buf[i] = src[rnd];
		}
		return new String(buf);
	}

	/**
	 * ���ø÷�������������ַ���
	 * 
	 * @param length
	 *            �漴�ַ�������
	 * @return �ⲿ���õ��ַ������Ա�Session����
	 */
	public String runVerifyCode(int length) {
		String VerifyCode = randString(length);
		return VerifyCode;
	}

	/**
	 * ������Χ��������ɫ
	 * 
	 * @param fc
	 *            ��ԭɫ��Rֵ
	 * @param bc
	 *            ��ԭɫ��Bֵ
	 * @return ͨ����ԭɫ�����Color����
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * ���ø÷������õ�����֤������ͼ��
	 * 
	 * @param sCode
	 *            ������֤���ַ���
	 *            <p>
	 *            w:ͼ���� h:ͼ��߶�
	 *            </p>
	 * @return ������֤���ͼƬ��
	 */
	public BufferedImage CreateImage(String sCode) {
		// �ַ�������
		Font CodeFont = new Font("Arial Black", Font.PLAIN, 16);
		int iLength = sCode.length();// �õ���֤�볤��
		int width = 24 * iLength, height = 20;// ͼ������߶�
		int CharWidth = (int) (width - 24) / iLength; // �ַ�����߿��
		int CharHeight = 16; // �ַ����ϱ߸߶�

		// ���ڴ��д���ͼ��
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// ��ȡͼ��������
		Graphics g = image.getGraphics();

		// ���������
		Random random = new Random();

		// �趨����ɫ
		g.setColor(getRandColor(200, 240));
		g.fillRect(0, 0, width, height);

		// �趨����
		g.setFont(CodeFont);

		// �������ɫ�ı߿�
		g.setColor(getRandColor(10, 50));
		g.drawRect(0, 0, width - 1, height - 1);

		// �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		for (int i = 0; i < iLength; i++) {
			String rand = sCode.substring(i, i + 1);
			// ����֤����ʾ��ͼ����
			g.setColor(new Color(20 + random.nextInt(60), 20 + random
					.nextInt(120), 20 + random.nextInt(180)));
			g.drawString(rand, CharWidth * i + 14, CharHeight);
		}
		// ͼ����Ч
		g.dispose();
		return image;
	}
}
