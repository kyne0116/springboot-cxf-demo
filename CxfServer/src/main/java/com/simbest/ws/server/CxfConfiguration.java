package com.simbest.ws.server;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lishuyi
 */
@Configuration
public class CxfConfiguration {

    /**
     * @param bus
     * @return
     */
    @Bean
    public Server helloBus(SpringBus bus) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloWorldImpl.class);
        factory.setAddress("/hello");
        return wrapperBus(bus, factory);
    }

    /**
     * @param bus
     * @return
     */
    @Bean
    public Server humanBus(SpringBus bus) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HumanSrvServiceImpl.class);
        factory.setAddress("/human");
        return wrapperBus(bus, factory);
    }

    private Server wrapperBus(SpringBus bus, JaxWsServerFactoryBean factory){
        factory.setBus(bus);
        //bean.setFeatures(Collections.singletonList(new LoggingFeature()));

        //outputs the received message to the logger
        LoggingInInterceptor loggingInInterceptor = new CustomLoggingInInterceptor();
        factory.getInInterceptors().add(loggingInInterceptor);

        //outputs the sent message to the logger
        LoggingOutInterceptor loggingOutInterceptor = new CustomLoggingOutInterceptor();
        factory.getOutInterceptors().add(loggingOutInterceptor);

        //Auth request by header
        factory.getInInterceptors().add(new AuthInterceptor());

        return factory.create();
    }
}
