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
  entityManagerFactoryRef = "garageEntityManagerFactory",
  transactionManagerRef = "garageTransactionManager",
  basePackages = { "com.research.garage.*" }
)
public class GarageDBConfig {
	
	@Bean(name="garageDataSource")
	@ConfigurationProperties(prefix="spring.garagedatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "garageEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("garageDataSource") DataSource garageDataSource) {
		return builder
				.dataSource(garageDataSource)
				.packages("com.research.garage.*")
				.build();
	}

	@Bean(name = "garageTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("garageEntityManagerFactory") EntityManagerFactory garageEntityManagerFactory) {
		return new JpaTransactionManager(garageEntityManagerFactory);
	}
}