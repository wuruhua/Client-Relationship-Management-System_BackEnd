package com.crm.cust.action;

import com.crm.common.entity.CstActivity;
import com.crm.common.entity.CstCustomer;
import com.crm.common.entity.CstLinkman;
import com.crm.common.entity.OrderLine;
import com.crm.common.entity.Orders;
import com.crm.cust.biz.ActivityBiz;
import com.crm.cust.biz.CustomerBiz;
import com.crm.cust.biz.LinkmanBiz;
import com.crm.cust.biz.OrdersBiz;
import com.crm.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * 客户信息管理action
 * 
 * @author Fiona
 * 
 */
public class CustomerAction extends ActionSupport {

	HttpServletResponse response = ServletActionContext.getResponse();
	/**
	 * 
	 */
	private static final long serialVersionUID = -1771604123774212904L;
	@SuppressWarnings("unchecked")
	private List customerList;// 列表
	private String id;//
	private String cust_No;
	@SuppressWarnings("unchecked")
	private List dictList;

	CstCustomer customer = new CstCustomer();
	CstLinkman linkman = new CstLinkman();
	CstActivity activity = new CstActivity();
	Orders orders = new Orders();
	OrderLine line=new OrderLine();

	private CustomerBiz customerBiz;
	private LinkmanBiz linkmanBiz;
	private ActivityBiz activityBiz;
	private OrdersBiz ordersBiz;

	private Page page;

	public CustomerAction() {
		page = new Page();
	}

	/**
	 * 转向客户信息页面
	 * 
	 * @return 客户信息页面字符串
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String toList() throws Exception {
		dictList = this.customerBiz.getList("from BasDic"
				+ "t dict where dict.dictType='地区'");
		List list = customerBiz.searchPage(page, null);
		page.setTotalRow(this.customerBiz.getCount(null));
		page.setPageList(list);
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String doList() throws Exception {
		dictList = this.customerBiz.getList("from BasDic"
				+ "t dict where dict.dictType='地区'");
		List list = customerBiz.searchPage(page, customer);
		page.setTotalRow(this.customerBiz.getCount(customer));
		page.setPageList(list);
		return "list";
	}

	/**
	 * 转向编辑客户信息页面
	 * 
	 * @return 编辑客户信息页面字符串
	 * @throws Exception
	 */
	public String toEdit() throws Exception {
		dictList = this.customerBiz.getList("from BasDic"
				+ "t dict where dict.dictType='地区'");
		customer = customerBiz.loadCstCustomer(id);
		return "edit";
	}

	/**
	 * 修改客户信息
	 * 
	 * @return 成功:success页面， 失败:error页面,否则:404页面
	 * @throws Exception
	 */
	public String doEdit() throws Exception {
		boolean flag = customerBiz.updateCstCustomer(customer);
		if (flag) {
			response
					.getWriter()
					.write(
							"<script>location.href='cust_customer_toList.action'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('修改客户信息失败!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * 删除客户信息
	 * 
	 * @return 成功:success页面， 失败:error页面,否则:404页面
	 * @throws Exception
	 */
	public String doDeleteList() throws Exception {
		boolean flag = true;
		customer.setCustNo(id);
		CstCustomer cust = this.customerBiz.loadCstCustomer(id);
		//cust.setCustStatus("1");
		//flag = customerBiz.updateCstCustomer(cust);
		flag=customerBiz.delCstCustomer(cust);
		if (flag) {
			response
					.getWriter()
					.write(
							"<script>location.href='cust_customer_toList.action'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('删除客户信息失败!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * 转向联系人信息页面
	 * 
	 * @return 联系人信息页面字符串
	 * @throws Exception
	 */
	public String toLinkman() throws Exception {
		customer = customerBiz.loadCstCustomer(id);// 加载客户信息
		customerList = linkmanBiz.searchAll(linkman, id);// 根据得到的客户编号查询客户的联系人信息
		return "linkman";
	}

	/**
	 * 转向编辑联系人信息页面
	 * 
	 * @return 编辑联系人信息页面字符串
	 * @throws Exception
	 */
	public String toLinkman_edit() throws Exception {
		linkman = linkmanBiz.getCstLinkmanById(Integer.parseInt(id));
		return "linkman_edit";
	}

	/**
	 * 更新联系人信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLinkman_edit() throws Exception {
		customer.setCustNo(id);
		linkman.setCstCustomer(customer);//把编号封装到linkman实体对中
		boolean flag = linkmanBiz.updateCstLinkman(linkman);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='cust_customer_toLinkman.action?id="
							+ id + "'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('更新联系人信息失败!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * 执行删除联系人操作
	 * 
	 * @return 联系人信息页面字符串
	 * @throws Exception
	 */
	public String doDelLinkman() throws Exception {
		boolean flag = linkmanBiz.delCstLinkman(Integer.parseInt(id));
		if (flag) {
			response.getWriter().write(
					"<script>location.href='cust_customer_toLinkman.action?id="
							+ cust_No + "'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('删除联系人失败!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * 转向新建联系人信息页面
	 * 
	 * @return 联系人信息页面字符串
	 * @throws Exception
	 */
	public String toLinkman_add() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String custNo = request.getParameter("id");
		request.setAttribute("custNo", custNo);
		return "linkman_add";
	}

	/**
	 * 增加联系人
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLinkman_add() throws Exception {
		customer.setCustNo(id);
		linkman.setCstCustomer(customer);
		boolean flag = linkmanBiz.addCstLinkman(linkman);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='cust_customer_toLinkman.action?id="
							+ id + "'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('增加联系人失败!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * 转向交往记录信息页面
	 * 
	 * @return 交往记录信息页面字符串
	 * @throws Exception
	 */
	public String toActivities() throws Exception {
		customer = customerBiz.loadCstCustomer(id);// 加载客户信息
		customerList = activityBiz.searchAll(activity, id);
		return "activities";
	}

	/**
	 * 转向编辑交往记录页面
	 * 
	 * @return 编辑交往记录页面字符串
	 * @throws Exception
	 */
	public String toActivities_edit() throws Exception {
		activity = activityBiz.getCstActivityById(Integer.parseInt(id));
		return "activities_edit";
	}

	/**
	 * 更新交往记录的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doActivities_edit() throws Exception {
		customer.setCustNo(id);
		activity.setCstCustomer(customer);
		boolean flag = activityBiz.updateCstActivity(activity);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='cust_customer_toActivities.action?id="
							+ id + "'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('更新交往记录信息失败!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * 执行删除交往记录
	 * 
	 * @return 交往记录页面字符串
	 * @throws Exception
	 */
	public String doDelActivities() throws Exception {
		boolean flag = activityBiz.delCstActivity(Integer.parseInt(id));
		if (flag) {
			response.getWriter().write(
					"<script>location.href='cust_customer_toActivities.action?id="
							+ cust_No + "'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('删除交往记录失败!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * 转向新建交往记录页面
	 * 
	 * @return 新建交往记录页面字符串
	 * @throws Exception
	 */
	public String toActivities_add() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String custNo = request.getParameter("id");
		request.setAttribute("custNo", custNo);
		return "activities_add";
	}

	/**
	 * 添加新的交往记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doActivities_add() throws Exception {
		customer.setCustNo(id);
		activity.setCstCustomer(customer);
		boolean flag = activityBiz.addCstActivity(activity);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='cust_customer_toActivities.action?id="
							+ id + "'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('添加新的交往记录失败!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * 转向历史订单页面
	 * 
	 * @return 历史订单页面字符串
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String toOrders() throws Exception {
		customer = this.customerBiz.loadCstCustomer(id);
		List list = this.ordersBiz.searchPage(page, null);
		page.setPageRow(this.ordersBiz.getCount(null));
		page.setPageList(list);
		return "orders";
	}

	@SuppressWarnings("unchecked")
	public String doOrders() throws Exception {
		customer = this.customerBiz.loadCstCustomer(id);
		List list = this.ordersBiz.searchPage(page, orders);
		page.setPageRow(this.ordersBiz.getCount(orders));
		page.setPageList(list);
		return "orders";
	}

	/**
	 * 转向订单明细页面
	 * 
	 * @return 订单明细页面字符串
	 * @throws Exception
	 */
	public String toOrders_detail() throws Exception {
		orders=this.ordersBiz.loadOrders(Integer.parseInt(id));
		dictList=this.ordersBiz.searOrderLine(line,Integer.parseInt(id));
		ActionContext.getContext().getSession().put("orders", orders);
		ActionContext.getContext().getSession().put("dictList", dictList);
		return "orders_detail";
	}

	public CstActivity getActivity() {
		return activity;
	}

	public void setActivity(CstActivity activity) {
		this.activity = activity;
	}

	public void setActivityBiz(ActivityBiz activityBiz) {
		this.activityBiz = activityBiz;
	}

	public void setCustomer(CstCustomer customer) {
		this.customer = customer;
	}

	public CstLinkman getLinkman() {
		return linkman;
	}

	public void setLinkman(CstLinkman linkman) {
		this.linkman = linkman;
	}

	public CstCustomer getCustomer() {
		return customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@SuppressWarnings("unchecked")
	public List getCustomerList() {
		return customerList;
	}

	@SuppressWarnings("unchecked")
	public void setCustomerList(List customerList) {
		this.customerList = customerList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setLinkmanBiz(LinkmanBiz linkmanBiz) {
		this.linkmanBiz = linkmanBiz;
	}

	public void setCustomerBiz(CustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}

	public void setOrdersBiz(OrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@SuppressWarnings("unchecked")
	public List getDictList() {
		return dictList;
	}

	@SuppressWarnings("unchecked")
	public void setDictList(List dictList) {
		this.dictList = dictList;
	}

	public String getCust_No() {
		return cust_No;
	}

	public void setCust_No(String custNo) {
		cust_No = custNo;
	}

	public OrderLine getLine() {
		return line;
	}

	public void setLine(OrderLine line) {
		this.line = line;
	}

}
