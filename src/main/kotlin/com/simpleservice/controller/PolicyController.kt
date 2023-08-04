package com.simpleservice.controller

import com.simpleservice.entity.Policy
import com.simpleservice.entity.User
import com.simpleservice.helper.Response
import com.simpleservice.repository.PolicyRepository
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import lombok.NonNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*

@RestController
class PolicyController {

    @Autowired
    lateinit var policyRepository: PolicyRepository

    @ApiOperation(value = "add policy", notes = "policy를 작성한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "Server DB Error")
    )
    @PostMapping("policy")
    fun add(@RequestBody policy: Policy) = run {
        try {
            val result = policyRepository.save(policy)
            val success = policy.title == result.title &&
                    policy.comment == result.comment
            Response.ok(success)
        } catch (exception: Exception) {
            Response.error()
        }
    }

    @ApiOperation(value = "PolicyList", notes = "정책 리스트를 반환한다")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "inTerm", value = "기간안의 데이터만 체크", required = false)
    )
    @GetMapping("/policies")
    fun policies(@RequestParam(required = false) inTerm: Boolean?) = run {
        val policies = policyRepository.findAll()

        if (inTerm == true) {
            val date = Date()
            Response.ok(
                policies
                    .filter {
                        it.start <= date && it.end >= date
                    }
            )
        } else {
            Response.ok(policies)
        }
    }

    @ApiOperation(value = "Get Policy", notes = "정책을 반환한다")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 404, message = "policy not found")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "id", value = "정책의 ID", required = true)
    )
    @GetMapping("/policy/{id}")
    fun policy(@PathVariable(name = "id") id: Long) = run {
        val policy = policyRepository.findById(id)
            .orElse(null)
        if (policy != null) {
            Response.ok(policy)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @ApiOperation(value = "Policy를 수정", notes = "Policy를 수정한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 404, message = "Policy not found"),
        ApiResponse(code = 500, message = "Policy modify error")
    )
    @PutMapping("policy")
    fun modify(@RequestBody policy: Policy) = run {
        val find = policyRepository.findById(policy.id)
            .map { find ->
                find.comment = policy.comment
                find.title = policy.title
                find.start = policy.start
                find.end = policy.end
                find
            }
            .orElse(null)

        if (find != null) {
            try {
                policyRepository.save(find)
                Response.ok(mapOf("success" to true))
            } catch (exception: Exception) {
                Response.error()
            }
        } else {
            ResponseEntity.notFound().build<Void>()
        }
    }

    @ApiOperation(value = "Delete Policy", notes = "정책을 삭제한다")
    @ApiResponses(
        ApiResponse(code = 204, message = "Success"),
        ApiResponse(code = 404, message = "Post is not found")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "id", value = "정책의 ID", required = true)
    )
    @DeleteMapping("/policy/{id}")
    fun delete(@PathVariable(name = "id") id: Long) = run {
        try {
            policyRepository.deleteById(id)
            ResponseEntity.noContent().build<Void>()
        } catch (exception: Exception) {
            ResponseEntity.notFound().build<Void>()
        }
    }
}
