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
 * 权限拦截器
 * 说明：AbstractInterceptor类是一个简单的Interceptor的实现的抽象类,该类实现了init()初始化方法和destroy
 * ()销毁方法,并且声明了intercept()抽象方法 任务：1.拦截未登录用户；2.对已经登录用户进行权限拦截
 */
@SuppressWarnings("serial")
public class RightInterceptor extends AbstractInterceptor {

	/**
	 * 重写父类拦截器主体方法
	 */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);// 获取request请求
		String url = "";// 用户要访问的url命名空间
		String namespace = invocation.getProxy().getNamespace();
		if (StringUtils.isNotBlank(namespace) && !namespace.equals("/")) {
			url = url + namespace;
		
		}
		// 获取要调用的action名称，如user_toLogin
		String actionName = invocation.getProxy().getActionName();
		// 判断actionName是否非空，注意：空格在这里当作空来处理
		if (StringUtils.isNotBlank(actionName)) {
			url = url + "/" + actionName + ".action";
			System.out.println("当前访问的页面url:" +url);
		}
		// 不拦截login操作
		if (url.equals("/user_manager_toLogin.action")
				|| url.equals("/user_manager_doLogin.action")
				|| url.equals("/user_manager_doLogout.action")) {
			return invocation.invoke();// 通过
		}
		// 判断session中是否存在LOGIN
		Map session = invocation.getInvocationContext().getSession();
		SysUser user = (SysUser) session.get("user");
		if (user != null) {// 如果用户已经登录并且有权限访问就继续执行下一个操作
			List<SysRight> rights = user.getSysRole().getSysRights();
			String[] u = null;// 以数组形式存储当前用户的url
			for (int i = 0; i < rights.size(); i++) {
				SysRight sr = (SysRight) rights.get(i);
				String ul = sr.getRightUrl();
//				System.out.println("该角色所包含的所有访问权限地址："+ul);
				if (ul != "") {
					u = ul.split(",");// 以逗号为分割点
					for (int j = 0; j < u.length; j++) {
						if (url.equals("/" + u[j])) {// 如果用户要访问的url属于当前用户权限，则可以继续操作
							return invocation.invoke();// 通过
						}
					}
				}
			}
			request.setAttribute(GlobalsConstUtil.MSG_KEY, "您无权访问该页面或该页面不存在");// 失败原因
			request.setAttribute(GlobalsConstUtil.PAGENAME, "上一操作");// 返回的页面的名称
			request.setAttribute(GlobalsConstUtil.MSGURL,
					"javascript:history.go(-1)");// 返回的页面的地址
			return Action.ERROR;// 失败页面
		}
		return Action.LOGIN;
	}
}
