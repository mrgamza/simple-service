package com.simpleservice.controller

import com.simpleservice.dto.PolicyResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PolicyController {

    @GetMapping("/policy")
    fun policy() = run {
        val startDate = Date()
        val endDate = Date()

        ResponseEntity
            .ok(listOf(
                PolicyResponseDto(0, "Test1", startDate, endDate),
                PolicyResponseDto(1, "Test2", startDate, endDate),
                PolicyResponseDto(2, "Test3", startDate, endDate),
                PolicyResponseDto(3, "Test4", startDate, endDate)
            ))
    }

    @GetMapping("/policy/{id}")
    fun policy(@PathVariable("id") id: Int) = run {
        val startDate = Date()
        val endDate = Date()

        ResponseEntity
            .ok(PolicyResponseDto(id, "Test${id}", startDate, endDate))
    }
}
