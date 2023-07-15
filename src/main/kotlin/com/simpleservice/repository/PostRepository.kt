package com.simpleservice.repository

import com.simpleservice.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitle(title: String): List<Post>

    fun findByName(name: String): List<Post>

    fun findByNameAndTitle(name: String, title: String): List<Post>
}
