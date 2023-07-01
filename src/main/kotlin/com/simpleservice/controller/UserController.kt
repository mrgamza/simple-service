package com.simpleservice.controller

import com.simpleservice.entity.donghyuk.User
import com.simpleservice.repository.donghyuk.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @PostMapping("user")
    fun add(@RequestBody user: User) = run {
        val result = userRepository.save(user)
        val success = user.name == result.name && user.age == result.age

        ResponseEntity.ok(success)
    }

    @GetMapping("user")
    fun getUser(@RequestParam(required = false) name: String?) = run {
        val user = if (name != null) {
            userRepository.findByName(name)
        } else {
            userRepository.findAll()
        }

        ResponseEntity.ok(user)
    }
}
