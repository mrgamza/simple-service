package com.simpleservice.controller

import com.simpleservice.entity.Student
import com.simpleservice.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @PostMapping("student")
    fun add(@RequestBody student: Student) = run {
        val result = studentRepository.save(student)
        val success = student.name == result.name && student.age == result.age

        ResponseEntity.ok(success)
    }

    @GetMapping("student")
    fun getUser(@RequestParam(required = false) name: String?) = run {
        val student = if (name != null) {
            studentRepository.findByName(name)
        } else {
            studentRepository.findAll()
        }

        ResponseEntity.ok(student)
    }
}
