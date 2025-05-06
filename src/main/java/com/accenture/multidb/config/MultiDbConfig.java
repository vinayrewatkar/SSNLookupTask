package com.accenture.multidb.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MultiDbConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.personal")
    public DataSourceProperties personalProps() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource personalDataSource() {
        return personalProps().initializeDataSourceBuilder().build();
    }

    @Bean(name = "personalEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean personalEmf(
            EntityManagerFactoryBuilder builder,
            HibernateProperties hibernateProps,
            JpaProperties jpaProps) {

        // Merge JPA and Hibernate settings into one map
        Map<String, Object> merged = hibernateProps.determineHibernateProperties(
                jpaProps.getProperties(),
                new org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings()
        );

        return builder
                .dataSource(personalDataSource())
                .packages(
                        "com.accenture.multidb.personal",
                        "com.accenture.multidb.auth"      // ← add this
                )
                .persistenceUnit("personalPU")
                .properties(merged)
                .build();
    }

    @Bean(name = "personalTxMgr")
    @Primary
    public PlatformTransactionManager personalTxMgr(
            @Qualifier("personalEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    @ConfigurationProperties("spring.datasource.employment")
    public DataSourceProperties employmentProps() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource employmentDataSource() {
        return employmentProps().initializeDataSourceBuilder().build();
    }

    @Bean(name = "employmentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean employmentEmf(
            EntityManagerFactoryBuilder builder,
            HibernateProperties hibernateProps,
            JpaProperties jpaProps) {

        Map<String, Object> merged = hibernateProps.determineHibernateProperties(
                jpaProps.getProperties(),
                new org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings()
        );

        return builder
                .dataSource(employmentDataSource())
                .packages("com.accenture.multidb.employment")
                .persistenceUnit("employmentPU")
                .properties(merged)
                .build();
    }

    @Bean(name = "employmentTxMgr")
    public PlatformTransactionManager employmentTxMgr(
            @Qualifier("employmentEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    @ConfigurationProperties("spring.datasource.financial")
    public DataSourceProperties financialProps() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource financialDataSource() {
        return financialProps().initializeDataSourceBuilder().build();
    }

    @Bean(name = "financialEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean financialEmf(
            EntityManagerFactoryBuilder builder,
            HibernateProperties hibernateProps,
            JpaProperties jpaProps) {

        Map<String, Object> merged = hibernateProps.determineHibernateProperties(
                jpaProps.getProperties(),
                new org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings()
        );

        return builder
                .dataSource(financialDataSource())
                .packages("com.accenture.multidb.financial")
                .persistenceUnit("financialPU")
                .properties(merged)
                .build();
    }

    @Bean(name = "financialTxMgr")
    public PlatformTransactionManager financialTxMgr(
            @Qualifier("financialEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
