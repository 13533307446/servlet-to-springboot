package com.demo.servlet3;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

public class App 
{
	public static void main(String[] args) throws Exception {
		//创建Tomcat容器
		Tomcat tomcatServer = new Tomcat();
		//端口号设置
		tomcatServer.setPort(8080);
		//读取项目路径 加载静态资源
		//"/servlet3"参数也改成/，访问路径有所区别
		//http://localhost:8080/servlet3/hello
		//http://localhost:8080/hello
		tomcatServer.addWebapp("/servlet3", new File("src/main").getAbsolutePath());
		//启动，会自动扫描javax.servlet.ServletContainerInitializer配置
		tomcatServer.start();
		System.out.println("tomcat启动成功...");
		//异步等待请求执行
		tomcatServer.getServer().await();
	}

}
