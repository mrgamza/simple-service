package com.simpleservice.constant

enum class ResultCode(val code: String, val message: String) {
    SUCCESS("0000", "Success"),
    DB_ERROR("1000", "Fail DB Error"),
    KNOWN_ERROR("9000", "Server known error")
}
