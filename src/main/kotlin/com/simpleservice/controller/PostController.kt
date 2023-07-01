package com.simpleservice.controller

import com.simpleservice.entity.noticeBoard.Post
import com.simpleservice.repository.noticeBoard.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController {

    @Autowired
    private lateinit var postRepository: PostRepository

    @PostMapping("post")
    fun add(@RequestBody student: Post) = run {
        val result = postRepository.save(student)
        val success = student.title == result.title &&
                student.comment == result.comment

        ResponseEntity.ok(success)
    }

    @GetMapping("post")
    fun getPost(@RequestParam(required = false) title: String?) = run {
        val student = if (title != null) {
            postRepository.findByTitle(title)
        } else {
            postRepository.findAll()
        }

        ResponseEntity.ok(student)
    }
}
