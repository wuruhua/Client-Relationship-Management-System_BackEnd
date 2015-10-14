package com.crm.filter;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.crm.common.entity.SysRight;
import com.crm.common.entity.SysUser;
import com.crm.util.GlobalsConstUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Ȩ��������
 * ˵����AbstractInterceptor����һ���򵥵�Interceptor��ʵ�ֵĳ�����,����ʵ����init()��ʼ��������destroy
 * ()���ٷ���,����������intercept()���󷽷� ����1.����δ��¼�û���2.���Ѿ���¼�û�����Ȩ������
 */
@SuppressWarnings("serial")
public class RightInterceptor extends AbstractInterceptor {

	/**
	 * ��д�������������巽��
	 */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);// ��ȡrequest����
		String url = "";// �û�Ҫ���ʵ�url�����ռ�
		String namespace = invocation.getProxy().getNamespace();
		if (StringUtils.isNotBlank(namespace) && !namespace.equals("/")) {
			url = url + namespace;
		
		}
		// ��ȡҪ���õ�action���ƣ���user_toLogin
		String actionName = invocation.getProxy().getActionName();
		// �ж�actionName�Ƿ�ǿգ�ע�⣺�ո������ﵱ����������
		if (StringUtils.isNotBlank(actionName)) {
			url = url + "/" + actionName + ".action";
			System.out.println("��ǰ���ʵ�ҳ��url:" +url);
		}
		// ������login����
		if (url.equals("/user_manager_toLogin.action")
				|| url.equals("/user_manager_doLogin.action")
				|| url.equals("/user_manager_doLogout.action")) {
			return invocation.invoke();// ͨ��
		}
		// �ж�session���Ƿ����LOGIN
		Map session = invocation.getInvocationContext().getSession();
		SysUser user = (SysUser) session.get("user");
		if (user != null) {// ����û��Ѿ���¼������Ȩ�޷��ʾͼ���ִ����һ������
			List<SysRight> rights = user.getSysRole().getSysRights();
			String[] u = null;// ��������ʽ�洢��ǰ�û���url
			for (int i = 0; i < rights.size(); i++) {
				SysRight sr = (SysRight) rights.get(i);
				String ul = sr.getRightUrl();
//				System.out.println("�ý�ɫ�����������з���Ȩ�޵�ַ��"+ul);
				if (ul != "") {
					u = ul.split(",");// �Զ���Ϊ�ָ��
					for (int j = 0; j < u.length; j++) {
						if (url.equals("/" + u[j])) {// ����û�Ҫ���ʵ�url���ڵ�ǰ�û�Ȩ�ޣ�����Լ�������
							return invocation.invoke();// ͨ��
						}
					}
				}
			}
			request.setAttribute(GlobalsConstUtil.MSG_KEY, "����Ȩ���ʸ�ҳ����ҳ�治����");// ʧ��ԭ��
			request.setAttribute(GlobalsConstUtil.PAGENAME, "��һ����");// ���ص�ҳ�������
			request.setAttribute(GlobalsConstUtil.MSGURL,
					"javascript:history.go(-1)");// ���ص�ҳ��ĵ�ַ
			return Action.ERROR;// ʧ��ҳ��
		}
		return Action.LOGIN;
	}
}
