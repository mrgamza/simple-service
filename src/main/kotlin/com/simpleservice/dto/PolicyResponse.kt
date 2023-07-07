package com.simpleservice.dto

import java.util.Date

data class PolicyResponse(
    val id: Int,
    val name: String,
    val start: Date,
    val end: Date
)
