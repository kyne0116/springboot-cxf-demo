package com.simbest.ws;

import com.simbest.ws.ws.HelloWorld;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @author lishuyi
 */
@Configuration
@ConfigurationProperties(prefix = "cxf")
public class CxfConfiguration {

    private static final String USER_NAME = "admin";
    private static final String PASS_WORD = "pass";

    private String serverUrl;

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    /**
     * @param bus
     * @return
     */
    @Bean
    public HelloWorld bus(SpringBus bus) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWorld.class);
        factory.setAddress(serverUrl);
        factory.setBus(bus);
        factory.setFeatures(Collections.singletonList(new LoggingFeature()));
        factory.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        return factory.create(HelloWorld.class);
    }

}
