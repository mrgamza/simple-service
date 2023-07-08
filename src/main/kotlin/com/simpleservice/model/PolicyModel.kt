package com.simpleservice.model

import java.util.Date

data class PolicyModel(
    val id: Int,
    val name: String,
    val start: Date,
    val end: Date
)
