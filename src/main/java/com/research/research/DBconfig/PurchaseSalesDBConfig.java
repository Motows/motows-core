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
  entityManagerFactoryRef = "purchasesalesEntityManagerFactory",
  transactionManagerRef = "purchasesalesTransactionManager",
  basePackages = { "com.research.purchasesales" }
)
public class PurchaseSalesDBConfig {
	
	@Bean(name="purchasesalesDataSource")
	@ConfigurationProperties(prefix="spring.purchasesalesdatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "purchasesalesEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("purchasesalesDataSource") DataSource purchasesalesDataSource) {
		return builder
				.dataSource(purchasesalesDataSource)
				.packages("com.research.purchasesales")
				.build();
	}

	@Bean(name = "purchasesalesTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("purchasesalesEntityManagerFactory") EntityManagerFactory purchasesalesEntityManagerFactory) {
		return new JpaTransactionManager(purchasesalesEntityManagerFactory);
	}
}