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
  entityManagerFactoryRef = "vehicleEntityManagerFactory",
  transactionManagerRef = "vehicleTransactionManager",
  basePackages = { "com.research.vehicle.*" }
)
public class VehicleDBConfig {
	
	@Bean(name="vehicleDataSource")
	@ConfigurationProperties(prefix="spring.vehicledatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "vehicleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("vehicleDataSource") DataSource vehicleDataSource) {
		return builder
				.dataSource(vehicleDataSource)
				.packages("com.research.vehicle.*")
				.build();
	}

	@Bean(name = "vehicleTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("vehicleEntityManagerFactory") EntityManagerFactory vehicleEntityManagerFactory) {
		return new JpaTransactionManager(vehicleEntityManagerFactory);
	}
}