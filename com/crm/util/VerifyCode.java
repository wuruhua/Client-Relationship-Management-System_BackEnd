package com.crm.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码生成辅助类
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
	 * 产生随机字符串
	 * 
	 * @param length
	 *            随机字符串的长度
	 * @return 随机字符串
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
	 * 调用该方法，产生随机字符串
	 * 
	 * @param length
	 *            随即字符串长度
	 * @return 外部调用的字符串，以便Session处理
	 */
	public String runVerifyCode(int length) {
		String VerifyCode = randString(length);
		return VerifyCode;
	}

	/**
	 * 给定范围获得随机颜色
	 * 
	 * @param fc
	 *            三原色的R值
	 * @param bc
	 *            三原色的B值
	 * @return 通过三原色构造的Color对象
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
	 * 调用该方法将得到的验证码生成图象
	 * 
	 * @param sCode
	 *            传递验证码字符串
	 *            <p>
	 *            w:图象宽度 h:图象高度
	 *            </p>
	 * @return 带有验证码的图片流
	 */
	public BufferedImage CreateImage(String sCode) {
		// 字符的字体
		Font CodeFont = new Font("Arial Black", Font.PLAIN, 16);
		int iLength = sCode.length();// 得到验证码长度
		int width = 24 * iLength, height = 20;// 图象宽度与高度
		int CharWidth = (int) (width - 24) / iLength; // 字符距左边宽度
		int CharHeight = 16; // 字符距上边高度

		// 在内存中创建图象
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 240));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(CodeFont);

		// 画随机颜色的边框
		g.setColor(getRandColor(10, 50));
		g.drawRect(0, 0, width - 1, height - 1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
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
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(60), 20 + random
					.nextInt(120), 20 + random.nextInt(180)));
			g.drawString(rand, CharWidth * i + 14, CharHeight);
		}
		// 图象生效
		g.dispose();
		return image;
	}
}
