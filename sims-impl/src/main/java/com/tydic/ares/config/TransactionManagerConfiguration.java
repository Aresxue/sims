package com.tydic.ares.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author: Ares
 * @date: 2020/4/10 13:57
 * @description:
 * @version: JDK 1.8
 */
@Configuration
public class TransactionManagerConfiguration
{
    @Bean(name = "jpa")
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory)
    {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "default")
    public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

}
