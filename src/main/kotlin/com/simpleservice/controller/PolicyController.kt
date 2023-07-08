package com.simpleservice.controller

import com.simpleservice.model.PolicyModel
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
            PolicyModel(0, "Test1", startDate, endDate),
            PolicyModel(1, "Test2", startDate, endDate),
            PolicyModel(2, "Test3", startDate, endDate),
            PolicyModel(3, "Test4", startDate, endDate)
        )

        Response.ok(data)
    }

    @GetMapping("/policy/{id}")
    fun policy(@PathVariable("id") id: Int) = run {
        val startDate = Date()
        val endDate = Date()

        Response.ok(PolicyModel(id, "Test${id}", startDate, endDate))
    }
}
