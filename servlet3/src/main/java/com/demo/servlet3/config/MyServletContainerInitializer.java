package com.demo.servlet3.config;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import com.demo.servlet3.servlet.HelloServlet;

public class MyServletContainerInitializer implements ServletContainerInitializer {

	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		//添加servlet
		Dynamic dynamic = ctx.addServlet("hello", HelloServlet.class);
		//URL映射
		dynamic.addMapping("/hello");
	}

}
