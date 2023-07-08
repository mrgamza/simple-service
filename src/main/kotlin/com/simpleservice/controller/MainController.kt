package com.simpleservice.controller

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class MainController {

    @ApiOperation(value = "Hello", notes = "Say Hello.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @RequestMapping("/", method = [RequestMethod.GET])
    @ResponseBody
    fun index() = run {
        ResponseEntity.ok("Hello, simple-service")
    }

    @RequestMapping("/", method = [RequestMethod.GET], produces = ["text/html"])
    fun view() = run {
        "main.html"
    }
}
