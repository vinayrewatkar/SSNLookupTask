package com.accenture.multidb.employment;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages             = "com.accenture.multidb.employment",
        entityManagerFactoryRef  = "employmentEntityManagerFactory",
        transactionManagerRef    = "employmentTxMgr"
)
public class EmploymentDbRepoConfig { }
