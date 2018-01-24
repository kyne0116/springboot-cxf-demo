package com.simbest.ws;

import com.simbest.ws.ws.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CxfJaxWsClientApplication {

	private static final Logger LOG = LoggerFactory.getLogger(CxfJaxWsClientApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CxfJaxWsClientApplication.class, args);
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		LOG.info(helloWorld.sayHello("Kyne"));
		SpringApplication.exit(context, () -> 0);
	}
}
