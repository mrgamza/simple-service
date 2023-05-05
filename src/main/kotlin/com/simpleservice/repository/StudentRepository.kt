package com.simpleservice.repository

import com.simpleservice.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findByName(name: String): List<Student>
}
