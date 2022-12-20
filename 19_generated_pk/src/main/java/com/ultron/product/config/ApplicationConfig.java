package com.ultron.product.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages = "com.ultron.product.model.dao")
@PropertySource("classpath:/sql.properties")
public class ApplicationConfig {

	@Bean
	public DataSource dataSource() {
		var builder = new EmbeddedDatabaseBuilder();
		builder.setName("DataSource");
		builder.setType(EmbeddedDatabaseType.HSQL);
		builder.addScript("classpath:/database.sql");
		return builder.build();
	}

	@Bean
	public JdbcTemplate template(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcOperations nameTemplate(DataSource datasource) {
		return new NamedParameterJdbcTemplate(datasource);
	}

}
