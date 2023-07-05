package com.simpleservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.OAS_30)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.simpleservice.controller"))
            .paths(PathSelectors.any())
            .build()
    }

    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Simple Service")
            .description("simple is best")
            .version("0.1")
            .build()
    }
}
