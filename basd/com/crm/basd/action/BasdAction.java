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

	public BasdAction() {// 构造函数
		page = new Page();
	}

	/**
	 * 转向数据字典管理页面 进到页面直接加载数据
	 * 
	 * @return 数据字典管理页面字符串
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
	 * 查询后 跳到 dict 页面
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
	 * 转向编辑数据字典条目页面
	 * 
	 * @return 编辑数据字典条目页面字符串
	 * @throws Exception
	 */

	public String toEditDict() throws Exception {
		// 加载
		bas = this.basdBiz.getBasDict(id);
		return "dict_edit";
	}

	/**
	 * 编辑数据字典信息
	 * 
	 * @return 跳转到toListDict（）方法
	 * @throws Exception
	 */
	public String doEditDict() throws Exception {
		// 获取response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flag = true;
		flag = this.basdBiz.updateBasDict(bas);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='base_toListDict.action'</script>");

		} else {
			response.getWriter().write(
					"<script>alert('编辑数据字典信息失败！');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * 转向新建数据字典条目页面
	 * 
	 * @return 编辑数据字典条目页面字符串
	 * @throws Exception
	 */
	public String toAddDict() throws Exception {
		return "dict_add";
	}

	/**
	 * 新建数据字典信息，保存成功
	 * 
	 * @return 跳到 toListDict（）方法
	 * @throws Exception
	 */
	public String doAddDict() throws Exception {
		// 获取response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flag = true;
		flag = this.basdBiz.addBasDict(bas);
		if (flag) {
			response.getWriter().write(
					"<script>location.href='base_toListDict.action'</script>");
		} else {
			response.getWriter().write(
					"<script>alert('新建数据字典信息失败！');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * 转向产品查询您页面
	 * 
	 * @return 产品查询页面字符串
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
	 * 根据条件查询产品
	 * 
	 * @return 产品查询页面字符串
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
	 * 转向查询库存页面
	 * 
	 * @return 查询库存页面字符串
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
	 * 根据条件查询库存
	 * 
	 * @return 查询库存页面字符串
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
	 * 执行删除数据字典条目页面
	 * 
	 * @return 数据字典条目页面字符串
	 * @throws Exception
	 */
	public String doDelDict() throws Exception {
		// 获取response请求
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
					"<script>alert('删除数据字典条目失败！');location.go(-1)</script>");
		}
		return null;
	}

	/**
	 * get()和set()方法
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
