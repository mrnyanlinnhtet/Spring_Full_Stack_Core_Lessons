package com.ultron;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ultron")
//@ImportResource(locations = "classpath:/beans.xml")
public class AppConfig {

//	@Bean
//	public ClientService clientService(AppService service) {
//		var client = new ClientService();
//		client.setService(service);
//		return client;
//	}

//	@Bean
//	@Qualifier("one")
//	public AppService serviceOne() {
//		return new AppServiceOne();
//
//	}
//	
//	@Bean
//	@Qualifier("two")
//	public AppService serviceTwo() {
//		return new AppServiceTwo();
//	}

//	@Bean
//	public CustomAutowireConfigurer configurer() {
//
//		var config = new CustomAutowireConfigurer();
//		config.setCustomQualifierTypes(Set.of(ServiceOne.class, ServiceTwo.class));
//
//		return config;
//	}

}
