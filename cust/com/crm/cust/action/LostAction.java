package com.crm.cust.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.crm.common.entity.CstLost;
import com.crm.cust.biz.LostBiz;
import com.crm.util.Page;

/**
 * �ͻ������ƻ�
 * 
 * @author Fiona
 * 
 */
public class LostAction extends ActionSupport {
    
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 
	 */
	private static final long serialVersionUID = -2148858599222679467L;

	CstLost cstLost = new CstLost();

	private LostBiz lostBiz;
	@SuppressWarnings("unchecked")
	private List lost;
	private Integer id;
	private Page page;

	public LostAction() {
		page = new Page();
	}


	
	/**
	 * ת��ͻ���ʧ����ҳ��
	 * 
	 * @return �ͻ���ʧ����ҳ���ַ���
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String toList() throws Exception {
		List list = lostBiz.searchPage(page, null);
		page.setTotalRow(this.lostBiz.getCount(null));
		page.setPageList(list);
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String doList() throws Exception {
		List list = lostBiz.searchPage(page, cstLost);
		page.setTotalRow(this.lostBiz.getCount(cstLost));
		page.setPageList(list);
		return "list";
	}

	/**
	 * ת��ȷ����ʧ��Ϣҳ��
	 * 
	 * @return ȷ����ʧҳ���ַ���
	 * @throws Exception
	 */
	public String toConfirm() throws Exception {
		cstLost = this.lostBiz.loadCstLost(id);
		return "confirm";
	}

	/**
	 * ��ʧԭ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doConfirm() throws Exception {
		CstLost lost = this.lostBiz.loadCstLost(cstLost.getLstId());
		lost.setLstReason(cstLost.getLstReason());
		this.lostBiz.updateCstLost(lost);
		return "to_list";
	}
	/**
	 * ȷ����ʧ������״̬
	 * @return
	 */
	public String doLst(){
		cstLost = this.lostBiz.loadCstLost(id);
		cstLost.setLstStatus("3");
		cstLost.setLstLostDate(new Date());
		this.lostBiz.updateCstLost(cstLost);
		return "to_list";
	}

	/**
	 * ת���ݻ���ʧҳ��
	 * 
	 * @return �ݻ���ʧҳ���ַ���
	 * @throws Exception
	 */
	public String toRelay() throws Exception {
		cstLost = this.lostBiz.loadCstLost(id);
		return "relay";
	}

	/**
	 * ׷���ݻ���ʩ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doRelay() throws Exception {
		String delay = request.getParameter("lstDelay");
		cstLost = this.lostBiz.loadCstLost(cstLost.getLstId());
		cstLost.setLstDelay(cstLost.getLstDelay() + "<br/>" + delay);
		this.lostBiz.updateCstLost(cstLost);
		return "to_list";
	}
	/**
	 * �ݻ���ʧ��ɾ������
	 * @return
	 * @throws Exception
	 */
	public String doDelLstRelay()throws Exception {
		cstLost = this.lostBiz.loadCstLost(id);
		this.lostBiz.delCstLost(cstLost);
		return "to_list";
	}

	public CstLost getCstLost() {
		return cstLost;
	}

	public void setCstLost(CstLost cstLost) {
		this.cstLost = cstLost;
	}

	@SuppressWarnings("unchecked")
	public List getLost() {
		return lost;
	}

	@SuppressWarnings("unchecked")
	public void setLost(List lost) {
		this.lost = lost;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setLostBiz(LostBiz lostBiz) {
		this.lostBiz = lostBiz;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
