package com.simpleservice.entity.donghyuk

import javax.persistence.*

@Entity
data class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val age: Int
)
