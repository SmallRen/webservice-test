package com.webservice.webservicetest.service;

import javax.jws.WebMethod;

/**
 * @author renbaojia 1406423298@qq.ocom
 * @version 1.0
 * @CREATED 2019/3/28 17:50:48
 * @des
 * @修改记录:
 **/

public interface IWebService {
    @WebMethod
    String sayHello(String name);
}
