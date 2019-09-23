package com.izeye.throwaway.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for the persistence layer.
 *
 * @author Johnny Lim
 */
@Configuration
public class PersistenceConfig {

	@Bean
	@ConfigurationProperties(prefix = "my.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

}
