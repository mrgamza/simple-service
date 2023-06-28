package com.simpleservice.controller

import com.simpleservice.dto.UserResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class MainController {

    @RequestMapping("/")
    @ResponseBody
    fun index() = run {
        ResponseEntity.ok("Hello, simple-service")
    }

    @RequestMapping("/", produces = ["text/html"])
    fun view() = run {
        "main.html"
    }
}
