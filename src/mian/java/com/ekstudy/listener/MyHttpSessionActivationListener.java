package com.ekstudy.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// 有一个对象即将被激活(反串行化)

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// 有一个对象即将被串行化

	}

}