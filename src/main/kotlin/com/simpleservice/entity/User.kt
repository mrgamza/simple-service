package com.simpleservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Table
@Entity
@EnableJpaAuditing
data class User(

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    @Column
    val name: String,

    @Column
    var age: Int,

    @Column
    var role: String,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private val createdAt: Timestamp?,

    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "updated_at")
    private val updatedAt: Timestamp?
)
