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
 * �ͻ���Ϣ����action
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
	private List customerList;// �б�
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
	 * ת��ͻ���Ϣҳ��
	 * 
	 * @return �ͻ���Ϣҳ���ַ���
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String toList() throws Exception {
		dictList = this.customerBiz.getList("from BasDic"
				+ "t dict where dict.dictType='����'");
		List list = customerBiz.searchPage(page, null);
		page.setTotalRow(this.customerBiz.getCount(null));
		page.setPageList(list);
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String doList() throws Exception {
		dictList = this.customerBiz.getList("from BasDic"
				+ "t dict where dict.dictType='����'");
		List list = customerBiz.searchPage(page, customer);
		page.setTotalRow(this.customerBiz.getCount(customer));
		page.setPageList(list);
		return "list";
	}

	/**
	 * ת��༭�ͻ���Ϣҳ��
	 * 
	 * @return �༭�ͻ���Ϣҳ���ַ���
	 * @throws Exception
	 */
	public String toEdit() throws Exception {
		dictList = this.customerBiz.getList("from BasDic"
				+ "t dict where dict.dictType='����'");
		customer = customerBiz.loadCstCustomer(id);
		return "edit";
	}

	/**
	 * �޸Ŀͻ���Ϣ
	 * 
	 * @return �ɹ�:successҳ�棬 ʧ��:errorҳ��,����:404ҳ��
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
					"<script>alert('�޸Ŀͻ���Ϣʧ��!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * ɾ���ͻ���Ϣ
	 * 
	 * @return �ɹ�:successҳ�棬 ʧ��:errorҳ��,����:404ҳ��
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
					"<script>alert('ɾ���ͻ���Ϣʧ��!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * ת����ϵ����Ϣҳ��
	 * 
	 * @return ��ϵ����Ϣҳ���ַ���
	 * @throws Exception
	 */
	public String toLinkman() throws Exception {
		customer = customerBiz.loadCstCustomer(id);// ���ؿͻ���Ϣ
		customerList = linkmanBiz.searchAll(linkman, id);// ���ݵõ��Ŀͻ���Ų�ѯ�ͻ�����ϵ����Ϣ
		return "linkman";
	}

	/**
	 * ת��༭��ϵ����Ϣҳ��
	 * 
	 * @return �༭��ϵ����Ϣҳ���ַ���
	 * @throws Exception
	 */
	public String toLinkman_edit() throws Exception {
		linkman = linkmanBiz.getCstLinkmanById(Integer.parseInt(id));
		return "linkman_edit";
	}

	/**
	 * ������ϵ����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLinkman_edit() throws Exception {
		customer.setCustNo(id);
		linkman.setCstCustomer(customer);//�ѱ�ŷ�װ��linkmanʵ�����
		boolean flag = linkmanBiz.updateCstLinkman(linkman);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='cust_customer_toLinkman.action?id="
							+ id + "'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('������ϵ����Ϣʧ��!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * ִ��ɾ����ϵ�˲���
	 * 
	 * @return ��ϵ����Ϣҳ���ַ���
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
					"<script>alert('ɾ����ϵ��ʧ��!');location.go(-1)</script>");
		}

		return null;
	}

	/**
	 * ת���½���ϵ����Ϣҳ��
	 * 
	 * @return ��ϵ����Ϣҳ���ַ���
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
	 * ������ϵ��
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
					"<script>alert('������ϵ��ʧ��!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * ת������¼��Ϣҳ��
	 * 
	 * @return ������¼��Ϣҳ���ַ���
	 * @throws Exception
	 */
	public String toActivities() throws Exception {
		customer = customerBiz.loadCstCustomer(id);// ���ؿͻ���Ϣ
		customerList = activityBiz.searchAll(activity, id);
		return "activities";
	}

	/**
	 * ת��༭������¼ҳ��
	 * 
	 * @return �༭������¼ҳ���ַ���
	 * @throws Exception
	 */
	public String toActivities_edit() throws Exception {
		activity = activityBiz.getCstActivityById(Integer.parseInt(id));
		return "activities_edit";
	}

	/**
	 * ���½�����¼����Ϣ
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
					"<script>alert('���½�����¼��Ϣʧ��!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * ִ��ɾ��������¼
	 * 
	 * @return ������¼ҳ���ַ���
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
					"<script>alert('ɾ��������¼ʧ��!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * ת���½�������¼ҳ��
	 * 
	 * @return �½�������¼ҳ���ַ���
	 * @throws Exception
	 */
	public String toActivities_add() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String custNo = request.getParameter("id");
		request.setAttribute("custNo", custNo);
		return "activities_add";
	}

	/**
	 * ����µĽ�����¼
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
					"<script>alert('����µĽ�����¼ʧ��!');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * ת����ʷ����ҳ��
	 * 
	 * @return ��ʷ����ҳ���ַ���
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
	 * ת�򶩵���ϸҳ��
	 * 
	 * @return ������ϸҳ���ַ���
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
