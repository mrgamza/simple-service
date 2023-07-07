package com.simpleservice.controller

import com.simpleservice.dto.PolicyResponse
import com.simpleservice.helper.Response
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PolicyController {

    @GetMapping("/policy")
    fun policy() = run {
        val startDate = Date()
        val endDate = Date()

        val data = listOf(
            PolicyResponse(0, "Test1", startDate, endDate),
            PolicyResponse(1, "Test2", startDate, endDate),
            PolicyResponse(2, "Test3", startDate, endDate),
            PolicyResponse(3, "Test4", startDate, endDate)
        )

        Response.ok(data)
    }

    @GetMapping("/policy/{id}")
    fun policy(@PathVariable("id") id: Int) = run {
        val startDate = Date()
        val endDate = Date()

        Response.ok(PolicyResponse(id, "Test${id}", startDate, endDate))
    }
}
