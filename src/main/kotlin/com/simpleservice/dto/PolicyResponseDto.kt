package com.simpleservice.dto

import java.util.Date

data class PolicyResponseDto(
    val id: Int,
    val name: String,
    val start: Date,
    val end: Date
)
