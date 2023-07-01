package com.simpleservice.repository.noticeBoard

import com.simpleservice.entity.noticeBoard.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitle(title: String): List<Post>
}
