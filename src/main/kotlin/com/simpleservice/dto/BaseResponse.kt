package com.simpleservice.dto

data class BaseResponse(
    val resultCode: String,
    val resultMessage: String,
    val data: Any?
)
