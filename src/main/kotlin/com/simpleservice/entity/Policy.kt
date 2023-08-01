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
    val id: Long,

    @Column
    var title: String,

    @Column
    var comment: String,

    @Column
    var start: Date,

    @Column
    var end: Date,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private val createdAt: Timestamp,

    @JsonIgnore
    @Column(name = "updated_at")
    private val updatedAt: Timestamp
)
