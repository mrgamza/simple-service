package com.simpleservice.controller

import com.simpleservice.entity.User
import com.simpleservice.helper.Response
import com.simpleservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RestController
class UserController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @PostMapping("user")
    fun add(@RequestBody user: User) = run {
        val result = userRepository.save(user)
        val success = user.name == result.name
                && user.age == result.age
                && user.role == result.role

        Response.ok(success)
    }

    @GetMapping("user")
    fun getUser(@RequestParam(required = false) name: String?) = run {
        val user = if (name != null) {
            userRepository.findByName(name)
        } else {
            userRepository.findAll()
        }

        Response.ok(user)
    }

    @PutMapping("user")
    fun modify(@RequestBody user: User) = run {
        val finds = userRepository.findByName(user.name)
            .map { find ->
                find.age = user.age
                find
            }

        val saved = userRepository.saveAll(finds)
        Response.ok(mapOf("successCount" to saved.size))
    }

    @DeleteMapping("user")
    fun modify(@RequestParam name: String) = run {
        val finds = userRepository.findByName(name)
        userRepository.deleteAll(finds)
        Response.ok(mapOf("successCount" to finds.size))
    }
}
