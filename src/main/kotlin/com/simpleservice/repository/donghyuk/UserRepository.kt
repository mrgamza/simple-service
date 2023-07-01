package com.simpleservice.repository.donghyuk

import com.simpleservice.entity.donghyuk.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): List<User>
}
