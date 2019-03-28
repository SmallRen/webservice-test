package com.webservice.webservicetest.impl;

import com.webservice.webservicetest.service.IWebService;

import javax.jws.WebService;

/**
 * @author renbaojia 1406423298@qq.ocom
 * @version 1.0
 * @CREATED 2019/3/28 17:51:10
 * @des
 * @修改记录:
 **/

@WebService
public class WebServiceImpl implements IWebService {

    @Override
    public String sayHello(String name) {
        String said = name + ",Hello~~";
        System.out.println(said);
        return said;
    }
}