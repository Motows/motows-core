package com.research.research.DBconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "sparecatEntityManagerFactory",
  transactionManagerRef = "sparecatTransactionManager",
  basePackages = { "com.research.sparecat.*" }
)
public class SparecatDBConfig {
	
	@Bean(name="sparecatDataSource")
	@ConfigurationProperties(prefix="spring.sparecatdatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "sparecatEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("sparecatDataSource") DataSource sparecatDataSource) {
		return builder
				.dataSource(sparecatDataSource)
				.packages("com.research.sparecat.*")
				.build();
	}

	@Bean(name = "sparecatTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("sparecatEntityManagerFactory") EntityManagerFactory sparecatEntityManagerFactory) {
		return new JpaTransactionManager(sparecatEntityManagerFactory);
	}
}