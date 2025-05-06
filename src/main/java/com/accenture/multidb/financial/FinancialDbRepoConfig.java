package com.accenture.multidb.financial;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages             = "com.accenture.multidb.financial",
        entityManagerFactoryRef  = "financialEntityManagerFactory",
        transactionManagerRef    = "financialTxMgr"
)
public class FinancialDbRepoConfig { }
