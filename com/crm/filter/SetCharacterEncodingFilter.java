package com.crm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ÂÒÂë¹ýÂËÆ÷
 * 
*@author Fiona
 * 
 */
public class SetCharacterEncodingFilter implements Filter {
	protected FilterConfig filterConfig;
	protected String encodingName;
	protected boolean enable;

	public SetCharacterEncodingFilter() {
		this.encodingName = "GBK";
		this.enable = false;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
	}
}
