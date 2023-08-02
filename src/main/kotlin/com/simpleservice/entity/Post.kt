package com.simpleservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Table
@Entity
data class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    val id: Long,

    @Column
    val name: String,

    @Column
    var title: String,

    @Column
    var comment: String,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private val createdAt: Timestamp,

    @JsonIgnore
    @Column(name = "updated_at")
    private val updatedAt: Timestamp
)
