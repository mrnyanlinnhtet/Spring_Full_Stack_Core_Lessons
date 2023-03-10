package com.ultron.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("/database.properties")
@ComponentScan(basePackages = "com.ultron.dao")
public class AppConfig {

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Bean
	public DataSource datasource() {
//		var ds = new MysqlConnectionPoolDataSource();
//		ds.setUrl(url);
//		ds.setUser(username);
//		ds.setPassword(password);

		var config = new BoneCPConfig();
		config.setJdbcUrl(url);
		config.setUser(username);
		config.setPassword(password);

		return new BoneCPDataSource(config);
	}

	@Bean
	public JdbcTemplate template(DataSource dataSource) {

		return new JdbcTemplate(dataSource, true);
	}

}
