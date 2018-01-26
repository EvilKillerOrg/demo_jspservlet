package com.ekstudy.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//一次请求结算 销毁request的时候产生
		System.out.println("requestDestroyed>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		//request 初始化的时候产生
		System.out.println("requestInitialized>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

}