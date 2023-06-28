package com.simpleservice.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.donghyuk")
    fun donghyukSource() : DataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.notice-board")
    fun noticeBoardSource() : DataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }
}
