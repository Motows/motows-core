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
  entityManagerFactoryRef = "financeEntityManagerFactory",
  transactionManagerRef = "financeTransactionManager",
  basePackages = { "com.research.finance.*" }
)
public class FinanceDBConfig {
	
	@Bean(name="financeDataSource")
	@ConfigurationProperties(prefix="spring.financedatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "financeEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("financeDataSource") DataSource financeDataSource) {
		return builder
				.dataSource(financeDataSource)
				.packages("com.research.finance.*")
				.build();
	}

	@Bean(name = "financeTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("financeEntityManagerFactory") EntityManagerFactory financeEntityManagerFactory) {
		return new JpaTransactionManager(financeEntityManagerFactory);
	}
}