package com.simpleservice.controller

import com.simpleservice.entity.Post
import com.simpleservice.helper.Response
import com.simpleservice.repository.PostRepository
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
class PostController {

    @Autowired
    private lateinit var postRepository: PostRepository

    @ApiOperation(value = "add post", notes = "post를 작성한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "Server DB Error")
    )
    @PostMapping("post")
    fun add(@RequestBody post: Post) = run {
        try {
            val result = postRepository.save(post)
            val success = post.title == result.title &&
                    post.comment == result.comment

            Response.ok(success)
        } catch (exception: Exception) {
            Response.error()
        }
    }

    @ApiOperation(value = "get post for title or name", notes = "post를 가져온다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "title", value = "Post의 제목", required = false),
        ApiImplicitParam(name = "name", value = "Post 작성자 이름", required = false)
    )
    @GetMapping("post")
    fun fetchForTitle(@RequestParam(required = false) title: String?,
                      @RequestParam(required = false) name: String?) = run {
        var post = listOf<Post>()
        if (title != null && name != null) {
            post = postRepository.findByNameAndTitle(name, title)
        } else if (title != null) {
            post = postRepository.findByTitle(title)
        } else if (name != null) {
            post = postRepository.findByName(name)
        }

        Response.ok(post)
    }

    @ApiOperation(value = "get all posts", notes = "모든 post를 가져온다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @GetMapping("posts")
    fun fetchAllPosts() = run {
        val post = postRepository.findAll()
        Response.ok(post)
    }

    @ApiOperation(value = "Post를 수정", notes = "Post를 수정한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 404, message = "Post not found"),
        ApiResponse(code = 500, message = "Post modify error")
    )
    @PutMapping("post")
    fun modify(@RequestBody post: Post) = run {
        val find = postRepository.findById(post.id)
            .map { find ->
                find.comment = post.comment
                find.title = post.title
                find
            }
            .orElse(null)

        if (find != null) {
            try {
                postRepository.save(find)
                Response.ok(mapOf("success" to true))
            } catch (exception: Exception) {
                Response.error()
            }
        } else {
            ResponseEntity.notFound().build<Void>()
        }
    }

    @ApiOperation(value = "delete post", notes = "POST를 삭제한다.")
    @ApiResponses(
        ApiResponse(code = 204, message = "Success"),
        ApiResponse(code = 404, message = "Post is not found")
    )
    @DeleteMapping("posts/{id}")
    fun delete(@PathVariable(name = "id") id: Long) = run {
        try {
            postRepository.deleteById(id)
            ResponseEntity.noContent().build<Void>()
        } catch (exception: Exception) {
            ResponseEntity.notFound().build<Void>()
        }
    }
}
