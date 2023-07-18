package com.simpleservice.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainControllerTest {

    @Test
    @DisplayName("Main test")
    fun main() {
        val mainController = MainController()
        val result = mainController.index()
        assertEquals(result.statusCode.value(), 200)
    }
}
