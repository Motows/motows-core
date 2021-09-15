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
  entityManagerFactoryRef = "jobserviceEntityManagerFactory",
  transactionManagerRef = "jobserviceTransactionManager",
  basePackages = { "com.research.jobservice.*" }
)
public class JobserviceDBConfig {
	
	@Bean(name="jobserviceDataSource")
	@ConfigurationProperties(prefix="spring.jobservicedatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "jobserviceEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("jobserviceDataSource") DataSource jobserviceDataSource) {
		return builder
				.dataSource(jobserviceDataSource)
				.packages("com.research.jobservice.*")
				.build();
	}

	@Bean(name = "jobserviceTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("jobserviceEntityManagerFactory") EntityManagerFactory jobserviceEntityManagerFactory) {
		return new JpaTransactionManager(jobserviceEntityManagerFactory);
	}
}