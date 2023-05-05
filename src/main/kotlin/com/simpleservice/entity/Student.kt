package com.simpleservice.entity

import javax.persistence.Column
import javax.persistence.Entity

import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Student(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val age: Int
)
