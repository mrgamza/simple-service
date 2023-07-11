package com.simpleservice.controller

import com.simpleservice.model.PolicyModel
import com.simpleservice.helper.Response
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PolicyController {

    @ApiOperation(value = "PolicyList", notes = "정책 리스트를 반환한다")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
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

    @ApiOperation(value = "Get Policy", notes = "정책을 반환한다")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "id", value = "정책의 ID", required = true)
    )
    @GetMapping("/policy/{id}")
    fun policy(@PathVariable(name = "id") id: Int) = run {
        val startDate = Date()
        val endDate = Date()

        Response.ok(PolicyModel(id, "Test${id}", startDate, endDate))
    }
}
