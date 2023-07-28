package com.simpleservice.controller

import com.simpleservice.entity.Policy
import com.simpleservice.helper.Response
import com.simpleservice.repository.PolicyRepository
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PolicyController {

    @Autowired
    lateinit var policyRepository: PolicyRepository

    @ApiOperation(value = "add policy", notes = "policy를 작성한다.")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @PostMapping("policy")
    fun add(@RequestBody policy: Policy) = run {
        val result = policyRepository.save(policy)
        val success = policy.title == result.title &&
                policy.comment == result.comment

        Response.ok(success)
    }

    @ApiOperation(value = "PolicyList", notes = "정책 리스트를 반환한다")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @GetMapping("/policies")
    fun policies() = run {
        val policies = policyRepository.findAll()
        Response.ok(policies)
    }

    @ApiOperation(value = "Get Policy", notes = "정책을 반환한다")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "id", value = "정책의 ID", required = true)
    )
    @GetMapping("/policy/{id}")
    fun policy(@PathVariable(name = "id") id: Long) = run {
        val policy = policyRepository.findById(id)
            .orElse(null)
        Response.ok(policy)
    }

    @ApiOperation(value = "Delete Policy", notes = "정책을 삭제한다")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK")
    )
    @ApiImplicitParams(
        ApiImplicitParam(name = "id", value = "정책의 ID", required = true)
    )
    @DeleteMapping("/policy/{id}")
    fun delete(@PathVariable(name = "id") id: Long) = run {
        policyRepository.deleteById(id)
        val result = policyRepository.findById(id)
            .orElse(null)
        if (result == null) {
            ResponseEntity.noContent().build()
        } else {
            Response.ok(mapOf("success" to false))
        }
    }
}
