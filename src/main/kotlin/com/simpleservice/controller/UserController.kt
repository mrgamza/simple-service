package com.simpleservice.controller

import com.simpleservice.entity.User
import com.simpleservice.helper.Response
import com.simpleservice.repository.UserRepository
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class UserController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @ApiOperation(value = "add user", notes = "user를 등록한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "Server DB Error")
    )
    @PostMapping("user")
    fun add(@RequestBody user: User) = run {
        try {
            val result = userRepository.save(user)
            val success = user.name == result.name
                    && user.age == result.age
                    && user.role == result.role

            Response.ok(success)
        } catch (exception: Exception) {
            Response.error()
        }
    }

    @ApiOperation(value = "get user", notes = "user 조회한다. name이 null이면 모두 조회")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @GetMapping("user")
    fun getUser(@RequestParam(required = false) name: String?) = run {
        val user = if (name != null) {
            userRepository.findByName(name)
        } else {
            userRepository.findAll()
        }

        Response.ok(user)
    }

    @ApiOperation(value = "user를 수정", notes = "user를 수정한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 404, message = "User not found"),
        ApiResponse(code = 500, message = "User modify error")
    )
    @PutMapping("user")
    fun modify(@RequestBody user: User) = run {
        val finds = userRepository.findByName(user.name)
            .map { find ->
                find.age = user.age
                find
            }

        if (finds.isEmpty()) {
            ResponseEntity.notFound().build<Void>()
        } else {
            try {
                val saved = userRepository.saveAll(finds)
                Response.ok(mapOf("successCount" to saved.size))
            } catch (exception: Exception) {
                Response.error()
            }
        }
    }

    @ApiOperation(value = "user를 삭제", notes = "user를 삭제한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 404, message = "User not found"),
        ApiResponse(code = 500, message = "User modify error")
    )
    @DeleteMapping("user")
    fun delete(@RequestParam name: String) = run {
        val finds = userRepository.findByName(name)
        if (finds.isEmpty()) {
            ResponseEntity.notFound().build<Void>()
        } else {
            try {
                userRepository.deleteAll(finds)
                Response.ok(mapOf("successCount" to finds.size))
            } catch (exception: Exception) {
                Response.error()
            }
        }
    }
}
