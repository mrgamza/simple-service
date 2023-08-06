package com.simpleservice.controller

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class HTMLController {

    @RequestMapping("/", method = [RequestMethod.GET], produces = ["text/html"])
    fun view() = run {
        "main.html"
    }

    @RequestMapping("/policies", method = [RequestMethod.GET], produces = ["text/html"])
    fun getPolicies() = run {
        "get_policies.html"
    }
}
