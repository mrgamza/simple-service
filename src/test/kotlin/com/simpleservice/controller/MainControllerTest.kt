package com.simpleservice.controller

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
        val result = mainController.index()
        assertEquals(result.statusCode.value(), 200)
        assertEquals(result.body, "Hello, simple-service")
    }

    @Test
    @DisplayName("View test")
    fun view_test() {
        val result = mainController.view()
        assertEquals(result, "main.html")
    }
}
