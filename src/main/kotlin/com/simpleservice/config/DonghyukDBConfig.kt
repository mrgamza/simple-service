package com.simpleservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["com.simpleservice.repository.donghyuk"],
    entityManagerFactoryRef = "donghyukEntityManager",
    transactionManagerRef = "donghyukTransactionManager"
)
class DonghyukDBConfig {

    @Primary
    @Bean
    fun donghyukEntityManager(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = donghyukDatasource()
        em.setPackagesToScan("com.simpleservice.entity.donghyuk")
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()

        val properties: MutableMap<String, Any?> = HashMap()
        properties["hibernate.physical_naming_strategy"] = SpringPhysicalNamingStrategy::class.java.name
        properties["hibernate.implicit_naming_strategy"] = SpringImplicitNamingStrategy::class.java.name
        em.setJpaPropertyMap(properties)

        return em
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun donghyukDatasource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Primary
    @Bean
    fun donghyukTransactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = donghyukEntityManager().getObject()

        return transactionManager
    }
}

