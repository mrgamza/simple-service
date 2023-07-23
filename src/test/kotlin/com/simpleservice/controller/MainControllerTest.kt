package com.simpleservice.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MainControllerTest {

    @Autowired
    lateinit var mainController: MainController

    @Test
    @DisplayName("Main test")
    fun main_test() {
        // given

        // when
        val result = mainController.index()

        // then
        Assertions.assertThat(result.statusCode.value()).isEqualTo(200)
        Assertions.assertThat(result.body).isEqualTo("Hello, simple-service")
    }

    @Test
    @DisplayName("View test")
    fun view_test() {
        // given

        // when
        val result = mainController.view()

        // then
        Assertions.assertThat(result).isEqualTo("main.html")
    }
}
