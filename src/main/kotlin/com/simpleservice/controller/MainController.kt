package com.simpleservice.controller

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MainController {

    @ApiOperation(value = "Hello", notes = "Say Hello.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @GetMapping("/")
    fun index() = run {
        ResponseEntity.ok("Hello, simple-service")
    }
}
