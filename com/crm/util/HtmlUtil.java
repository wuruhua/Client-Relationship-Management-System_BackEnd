package com.crm.util;

/**
 * 用户输入内容,过滤威胁字符类
 * 
 *
 * 
 */
public class HtmlUtil {

	/**
	 * 过滤特殊字符 如：&、<、>、"、'
	 * 
	 * @param targetString
	 *            目标字符串
	 * @return 相对安全的字符串
	 */
	public String escapeHtml(String targetString) {
		// 注意先后顺序，只有先替换了&才可以替换其他哦
		return targetString.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll(
						"'", "&#039;");
	}

	/**
	 * 反过滤特殊字符
	 * 
	 * @param targetString
	 *            目标字符串
	 * @return HTML字符串
	 */
	public String unescapeHtml(String targetString) {
		// 注意先后顺序，只有先替换了&才可以替换其他哦
		return targetString.replaceAll("&amp;", "&").replaceAll("&lt;", "<")
				.replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll(
						"&#039;", "'");
	}
}
