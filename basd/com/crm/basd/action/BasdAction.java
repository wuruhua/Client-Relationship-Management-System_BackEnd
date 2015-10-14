package com.crm.basd.action;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.crm.basd.biz.BasdBiz;
import com.crm.basd.biz.ProductBiz;
import com.crm.basd.biz.StorageBiz;
import com.crm.common.entity.BasDict;
import com.crm.common.entity.Product;
import com.crm.common.entity.Storage;
import com.crm.util.Page;
import com.opensymphony.xwork2.ActionSupport;

public class BasdAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1732664765753251687L;

	private BasdBiz basdBiz;
	private BasDict bas;
	private Page page;
	private StorageBiz storageBiz;
	private Storage storage;
	private ProductBiz productBiz;
	private Product product;
	private Integer id;

	public void setBasdBiz(BasdBiz basdBiz) {
		this.basdBiz = basdBiz;
	}

	public BasdAction() {// ���캯��
		page = new Page();
	}

	/**
	 * ת�������ֵ����ҳ�� ����ҳ��ֱ�Ӽ�������
	 * 
	 * @return �����ֵ����ҳ���ַ���
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String toListDict() throws Exception {
		List listBas = this.basdBiz.serachAll(page, null);
		page.setTotalRow(this.basdBiz.getCount(null));
		page.setPageList(listBas);
		return "dict";
	}

	/**
	 * ��ѯ�� ���� dict ҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doListDict() throws Exception {
		List listBas = this.basdBiz.serachAll(page, bas);
		page.setTotalRow(this.basdBiz.getCount(bas));
		page.setPageList(listBas);
		return "dict";
	}

	/**
	 * ת��༭�����ֵ���Ŀҳ��
	 * 
	 * @return �༭�����ֵ���Ŀҳ���ַ���
	 * @throws Exception
	 */

	public String toEditDict() throws Exception {
		// ����
		bas = this.basdBiz.getBasDict(id);
		return "dict_edit";
	}

	/**
	 * �༭�����ֵ���Ϣ
	 * 
	 * @return ��ת��toListDict��������
	 * @throws Exception
	 */
	public String doEditDict() throws Exception {
		// ��ȡresponse����
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flag = true;
		flag = this.basdBiz.updateBasDict(bas);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='base_toListDict.action'</script>");

		} else {
			response.getWriter().write(
					"<script>alert('�༭�����ֵ���Ϣʧ�ܣ�');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * ת���½������ֵ���Ŀҳ��
	 * 
	 * @return �༭�����ֵ���Ŀҳ���ַ���
	 * @throws Exception
	 */
	public String toAddDict() throws Exception {
		return "dict_add";
	}

	/**
	 * �½������ֵ���Ϣ������ɹ�
	 * 
	 * @return ���� toListDict��������
	 * @throws Exception
	 */
	public String doAddDict() throws Exception {
		// ��ȡresponse����
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flag = true;
		flag = this.basdBiz.addBasDict(bas);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='base_toListDict.action'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('�½������ֵ���Ϣʧ�ܣ�');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * ת���Ʒ��ѯ��ҳ��
	 * 
	 * @return ��Ʒ��ѯҳ���ַ���
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String toListProduct() throws Exception {
		List list = this.productBiz.searchProductPage(page, null);
		page.setTotalRow(this.productBiz.getCount(null));
		page.setPageList(list);
		return "product";
	}

	/**
	 * ����������ѯ��Ʒ
	 * 
	 * @return ��Ʒ��ѯҳ���ַ���
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doListProduct() throws Exception {
		List list = this.productBiz.searchProductPage(page, product);
		page.setTotalRow(this.productBiz.getCount(product));
		page.setPageList(list);
		return "product";
	}

	/**
	 * ת���ѯ���ҳ��
	 * 
	 * @return ��ѯ���ҳ���ַ���
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String toListStorage() throws Exception {
		List list = this.storageBiz.searchStoragePage(page, null);
		page.setTotalRow(this.storageBiz.getCount(null));
		page.setPageList(list);
		return "storage";
	}

	/**
	 * ����������ѯ���
	 * 
	 * @return ��ѯ���ҳ���ַ���
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doListStorage() throws Exception {
		List list = this.storageBiz.searchStoragePage(page, storage);
		page.setTotalRow(this.storageBiz.getCount(storage));
		page.setPageList(list);
		return "storage";
	}

	/**
	 * ִ��ɾ�������ֵ���Ŀҳ��
	 * 
	 * @return �����ֵ���Ŀҳ���ַ���
	 * @throws Exception
	 */
	public String doDelDict() throws Exception {
		// ��ȡresponse����
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flag = true;
		bas = new BasDict();
		bas.setDictId(id);
		flag = this.basdBiz.delBasDict(bas);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='base_toListDict.action'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('ɾ�������ֵ���Ŀʧ�ܣ�');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * get()��set()����
	 * 
	 * @return
	 */
	public BasDict getBas() {
		return bas;
	}

	public void setBas(BasDict bas) {
		this.bas = bas;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setStorageBiz(StorageBiz storageBiz) {
		this.storageBiz = storageBiz;
	}

	public void setProductBiz(ProductBiz productBiz) {
		this.productBiz = productBiz;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
