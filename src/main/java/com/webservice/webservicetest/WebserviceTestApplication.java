package com.webservice.webservicetest;

import com.webservice.webservicetest.impl.WebServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class WebserviceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceTestApplication.class, args);


         /*
        在服务器端运行WebServicePublish类中的main方法，控制台打印出发布webservice成功！
        在浏览器中输入我们在WebServicePublish类中定义的url?wsdl(注意一定要加wsdl),浏览器显示一个xml文档
        那么我们这个WebService就发布成功了。
         */
        //定义webService的发布地址，提供给外界使用接口的地址
        String url = "http://localhost:8085/wsServeice";
        Endpoint.publish(url,new WebServiceImpl());
        System.out.println("发布webService成功！");
    }

}
