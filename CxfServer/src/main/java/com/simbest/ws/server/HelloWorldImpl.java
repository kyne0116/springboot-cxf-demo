package com.simbest.ws.server;

import com.simbest.ws.ws.HelloWorld;

/**
 * @author lishuyi
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + " welcome to Cxf World";
    }

}
