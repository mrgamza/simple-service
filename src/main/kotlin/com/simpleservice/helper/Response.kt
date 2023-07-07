package com.simpleservice.helper

import com.simpleservice.constant.ResultCode
import com.simpleservice.dto.BaseResponse
import org.springframework.http.ResponseEntity

class Response() {

    companion object {
        fun ok(data: Any? = null, resultCode: ResultCode = ResultCode.SUCCESS) = run {
            ResponseEntity.ok(
                BaseResponse(
                    resultCode.code,
                    resultCode.message,
                    data
                )
            )
        }
    }
}
