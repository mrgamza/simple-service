package com.simpleservice.helper

import com.simpleservice.constant.ResultCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ResponseBody(
    val resultCode: String,
    val resultMessage: String,
    val data: Any?
)

class Response {

    companion object {
        fun ok(data: Any? = null, resultCode: ResultCode = ResultCode.SUCCESS) = run {
            ResponseEntity.ok(
                ResponseBody(
                    resultCode.code,
                    resultCode.message,
                    data
                )
            )
        }

        fun error(resultCode: ResultCode = ResultCode.SERVER_INTERNAL_ERROR) = run {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                    ResponseBody(
                        resultCode.code,
                        resultCode.message,
                        null
                    )
                )
        }
    }
}
