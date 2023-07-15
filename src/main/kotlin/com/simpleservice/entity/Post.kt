package com.simpleservice.entity

import javax.persistence.*

@Table
@Entity
data class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val title: String,

    @Column
    val comment: String
)
