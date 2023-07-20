package com.simpleservice.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainControllerTest {

    @Test
    @DisplayName("Main test")
    fun main_test() {
        val mainController = MainController()
        val result = mainController.index()
        assertEquals(result.statusCode.value(), 200)
        assertEquals(result.body, "Hello, simple-service")
    }

    @Test
    @DisplayName("View test")
    fun view_test() {
        val mainController = MainController()
        val result = mainController.view()
        assertEquals(result, "main.html")
    }
}
