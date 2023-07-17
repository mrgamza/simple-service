package com.simpleservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.sql.Timestamp
import java.util.Date
import javax.persistence.*

@Table
@Entity
@EnableJpaAuditing
data class Policy(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private val id: Long? = null,

    @Column
    val title: String,

    @Column
    val comment: String,

    @Column
    val start: Date,

    @Column
    val end: Date,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private val createdAt: Timestamp,

    @JsonIgnore
    @Column(name = "updated_at")
    private val updatedAt: Timestamp
)
