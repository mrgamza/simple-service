package com.simpleservice.repository

import com.simpleservice.entity.Policy
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import java.sql.Timestamp
import java.util.*

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PolicyRepositoryTest {

    @Autowired
    private lateinit var policyRepository: PolicyRepository

    private var saveId: Long? = null

    @Test
    @Order(1)
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
    @Order(2)
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
        saveId = policies.id

        // then
        Assertions.assertThat(saveId).isNotNull()
    }

    @Test
    @Order(3)
    @DisplayName("policy를 가져온다.")
    fun test_get_policy() {
        // given
        val id = saveId!!

        // when
        val policies = policyRepository.findById(id).get()

        // then
        Assertions.assertThat(policies.id).isEqualTo(id)
    }

    @Test
    @Order(4)
    @DisplayName("policy를 삭제한다.")
    fun test_delete_policy() {
        // given
        val id = saveId!!

        // when
        policyRepository.deleteById(id)
        val policies = policyRepository.findByIdOrNull(id)

        // then
        Assertions.assertThat(policies).isNull()
    }
}
