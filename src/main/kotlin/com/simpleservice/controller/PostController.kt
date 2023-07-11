package com.simpleservice.controller

import com.simpleservice.entity.noticeBoard.Post
import com.simpleservice.helper.Response
import com.simpleservice.repository.noticeBoard.PostRepository
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController {

    @Autowired
    private lateinit var postRepository: PostRepository

    @ApiOperation(value = "add post", notes = "post를 작성한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "post", value = "Post의 내용", required = true)
    )
    @PostMapping("post")
    fun add(@RequestBody post: Post) = run {
        val result = postRepository.save(post)
        val success = post.title == result.title &&
                post.comment == result.comment

        Response.ok(success)
    }

    @ApiOperation(value = "get post", notes = "post를 가져온다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "title", value = "Post의 제목", required = false)
    )
    @GetMapping("post")
    fun fetch(@RequestParam(required = false) title: String?) = run {
        val post = if (title != null) {
            postRepository.findByTitle(title)
        } else {
            postRepository.findAll()
        }

        Response.ok(post)
    }
}
