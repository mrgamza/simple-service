package com.simpleservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.Date
import javax.persistence.*

@Table
@Entity
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

    @Column
    @JsonIgnore
    private val createdAt: Date,

    @Column
    @JsonIgnore
    private val updatedAt: Date
)
