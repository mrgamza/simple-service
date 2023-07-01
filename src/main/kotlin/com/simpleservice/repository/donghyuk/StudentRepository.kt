package com.simpleservice.repository.donghyuk

import com.simpleservice.entity.donghyuk.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findByName(name: String): List<Student>
}
