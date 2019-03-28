package com.webservice.webservicetest;

/**
 * @author renbaojia 1406423298@qq.ocom
 * @version 1.0
 * @CREATED 2019/3/28 18:00:04
 * @des
 * @修改记录:
 **/

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public class demo {
    //第一种方式
    public static void main(String[] args) {
        //创建动态客户端
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:8085/wsServeice?wsdl");
        // 需要密码的情况需要加上用户名和密码
        //client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(2000);  //连接超时
        httpClientPolicy.setAllowChunking(false);    //取消块编码
        httpClientPolicy.setReceiveTimeout(120000);     //响应超时
        conduit.setClient(httpClientPolicy);
        //client.getOutInterceptors().addAll(interceptors);//设置拦截器
        try {
            Object[] objects = new Object[0];
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sayHello", "sujin");
            System.out.println("返回数据:" + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //第二种

   // wsimport -s . -p com.gdjk.dems -keep  http://localhost:9090/ws?wsdl  生成类
   //Webservice webService = new Webservice();
    //IWebService iWebService = webService.getWebServicePort();
    //String result = iWebService.service(param, data);
}
