package com.simpleservice.repository

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PolicyRepositoryTest {

    @Autowired
    private lateinit var policyRepository: PolicyRepository

    @Test
    @DisplayName("전체 policy가 조회되는지 확인")
    fun saveMember() {
        // given
        // Nothing

        // when
        val policies = policyRepository.findAll()

        // then
        Assertions.assertThat(policies).isNotNull
    }
}
