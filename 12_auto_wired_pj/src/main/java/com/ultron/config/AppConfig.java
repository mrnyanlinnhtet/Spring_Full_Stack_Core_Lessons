package com.ultron.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@ComponentScan(basePackages = { "com.ultron" })
public class AppConfig {

	private static final String URL = "jdbc:mysql://localhost:3306/jdc_class";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	@Bean
	public DataSource datasource() {
		var ds = new MysqlDataSource();
		ds.setUrl(URL);
		ds.setUser(USER);
		ds.setPassword(PASSWORD);

		return ds;

	}

}
