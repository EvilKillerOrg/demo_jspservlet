package com.ekstudy.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
/**
 * implements Tag 接口 需要写好多方法 , 直接去 extends BodyTagSupport用到那个方法override哪个方法
 */
public class MyTaglib2 extends BodyTagSupport{

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doStartTag();
	}
	
}