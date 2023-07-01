package com.simpleservice.dto

data class BaseResponseDto(
    val resultCode: String,
    val resultMessage: String,
    val data: Any?
)
