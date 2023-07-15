package com.simpleservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Table
@Entity
data class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private val id: Long? = null,

    @Column
    val name: String,

    @Column
    val title: String,

    @Column
    val comment: String
)
