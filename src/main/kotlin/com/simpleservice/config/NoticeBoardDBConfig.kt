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
    basePackages = ["com.simpleservice.repository.noticeBoard"],
    entityManagerFactoryRef = "noticeBoardEntityManager",
    transactionManagerRef = "noticeBoardTransactionManager"
)
class NoticeBoardDBConfig {

    @Bean
    fun noticeBoardEntityManager(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = noticeBoardDatasource()
        em.setPackagesToScan("com.simpleservice.entity.noticeBoard")
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()

        val properties: MutableMap<String, Any?> = HashMap()
        properties["hibernate.physical_naming_strategy"] = SpringPhysicalNamingStrategy::class.java.name
        properties["hibernate.implicit_naming_strategy"] = SpringImplicitNamingStrategy::class.java.name
        em.setJpaPropertyMap(properties)

        return em
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.notice-datasource")
    fun noticeBoardDatasource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    fun noticeBoardTransactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = noticeBoardEntityManager().getObject()

        return transactionManager
    }
}

