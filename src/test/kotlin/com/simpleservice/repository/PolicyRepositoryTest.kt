package com.simpleservice.repository

import com.simpleservice.entity.Policy
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.sql.Timestamp
import java.util.*
import javax.persistence.Column

@SpringBootTest
class PolicyRepositoryTest {

    @Autowired
    private lateinit var policyRepository: PolicyRepository

    @Test
    @DisplayName("전체 policy가 조회되는지 확인")
    fun test_find_all_policy() {
        // given
        // Nothing

        // when
        val policies = policyRepository.findAll()

        // then
        Assertions.assertThat(policies).isNotNull
    }

    @Test
    @DisplayName("policy를 저장한다.")
    fun test_add_policy() {
        // given
        val policy = Policy(
            title = "TEST",
            comment = "TEST",
            start = Date(),
            end = Date(),
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis())
        )

        // when
        val policies = policyRepository.save(policy)

        // then
        Assertions.assertThat(policies).isNotNull
    }
}
