package com.simpleservice.entity

import javax.persistence.*

@Table
@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    var age: Int
)
