package com.ekstudy.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
/**
 * implements Tag 接口 需要写好多方法 , 直接去 extends BodyTagSupport用到那个方法override哪个方法
 */
public class MyTaglib implements Tag{

	private PageContext pageContext;
	private String name;
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().println("Hello My TabLib "+name+"!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		return this.EVAL_BODY_INCLUDE; // 这代表包含标签体  this.SKIP_BODY 跳过标签体
	}

	@Override
	public Tag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void release() {
		System.out.println("release");
		
	}

	@Override
	public void setPageContext(PageContext arg0) {
		pageContext = arg0;
		
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("setParent");
		
	}


	public void setName(String name) {
		this.name = name;
	}
}