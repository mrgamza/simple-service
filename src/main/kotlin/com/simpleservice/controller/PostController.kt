package com.simpleservice.controller

import com.simpleservice.constant.ResultCode
import com.simpleservice.entity.noticeBoard.Post
import com.simpleservice.helper.Response
import com.simpleservice.repository.noticeBoard.PostRepository
import io.swagger.annotations.*
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

        Response.ok(success)
    }

    @ApiOperation(value = "get post", notes = "post를 가져온다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(
            name = "title",
            value = "title",
            required = true,
            dataType = "string",
            paramType = "path",
            defaultValue = "None"
        )
    )
    @GetMapping("post")
    fun getPost(@RequestParam(required = false) title: String?) = run {
        val student = if (title != null) {
            postRepository.findByTitle(title)
        } else {
            postRepository.findAll()
        }

        Response.ok(student)
    }
}
