package com.accenture.multidb.personal;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {
                "com.accenture.multidb.personal",
                "com.accenture.multidb.auth"       // ← add this
        },
        entityManagerFactoryRef = "personalEntityManagerFactory",
        transactionManagerRef = "personalTxMgr"
)
public class PersonalDbRepoConfig {
}
