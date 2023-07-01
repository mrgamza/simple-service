package com.simpleservice.entity.noticeBoard

import javax.persistence.*

@Entity
data class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val title: String,

    @Column
    val comment: String
)
