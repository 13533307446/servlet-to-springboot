package com.demo.java_tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.Tomcat.FixContextListener;

public class App {
	private static int PORT = 8080; //启动端口
	private static String CONTEX_PATH = "/java_tomcat"; //contex 一般为项目名称
	private static String SERVLET_INDEXSERVLET = "indexServlet"; //IndexServlet.java映射名称
	private static String SERVLET_PATH_INDEXSERVLET = "/index"; //IndexServlet的doGet doPost入口

	public static void main(String[] args) throws LifecycleException, InterruptedException {

		//创建tomcat服务器
		Tomcat tomcatServer = new Tomcat();
		//指定端口号
		tomcatServer.setPort(PORT);
		//是否设置自动部署
		tomcatServer.getHost().setAutoDeploy(false);
		//创建上下文
		StandardContext standardContex = new StandardContext();
		standardContex.setPath(CONTEX_PATH);
		//监听上下文
		standardContex.addLifecycleListener(new FixContextListener());
		//tomcat容器添加standardContex
		tomcatServer.getHost().addChild(standardContex);
		//创建Servlet
		tomcatServer.addServlet(CONTEX_PATH, SERVLET_INDEXSERVLET, new IndexServlet());
		//servleturl映射
		standardContex.addServletMappingDecoded(SERVLET_PATH_INDEXSERVLET, SERVLET_INDEXSERVLET);
		tomcatServer.start();
		System.out.println("tomcat服务器启动成功..");
		//异步进行接收请求
		tomcatServer.getServer().await();

		//浏览器测试：http://localhost:8080/java_tomcat/index
	}

}
