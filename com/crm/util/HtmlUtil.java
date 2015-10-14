package com.crm.util;

/**
 * �û���������,������в�ַ���
 * 
 *
 * 
 */
public class HtmlUtil {

	/**
	 * ���������ַ� �磺&��<��>��"��'
	 * 
	 * @param targetString
	 *            Ŀ���ַ���
	 * @return ��԰�ȫ���ַ���
	 */
	public String escapeHtml(String targetString) {
		// ע���Ⱥ�˳��ֻ�����滻��&�ſ����滻����Ŷ
		return targetString.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll(
						"'", "&#039;");
	}

	/**
	 * �����������ַ�
	 * 
	 * @param targetString
	 *            Ŀ���ַ���
	 * @return HTML�ַ���
	 */
	public String unescapeHtml(String targetString) {
		// ע���Ⱥ�˳��ֻ�����滻��&�ſ����滻����Ŷ
		return targetString.replaceAll("&amp;", "&").replaceAll("&lt;", "<")
				.replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll(
						"&#039;", "'");
	}
}
