package com.simpleservice.repository

import com.simpleservice.entity.Policy
import com.simpleservice.entity.Post
import com.simpleservice.entity.User
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
class UserRepositoryTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    private var saveId: Long? = null

    @Test
    @Order(1)
    @DisplayName("전체 user를 조회한다.")
    fun test_find_all_user() {
        // given
        // Nothing

        // when
        val users = userRepository.findAll()

        // then
        Assertions.assertThat(users).isNotNull
    }

    @Test
    @Order(2)
    @DisplayName("user를 저장한다.")
    fun test_add_post() {
        // given
        val user = User(
            name = "TEST",
            age = 100,
            role = "admin",
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis())
        )

        // when
        val savedUser = userRepository.save(user)
        saveId = savedUser.id

        // then
        Assertions.assertThat(saveId).isNotNull()
    }

    @Test
    @Order(3)
    @DisplayName("user를 가져온다.")
    fun test_get_user() {
        // given
        val id = saveId!!

        // when
        val post = userRepository.findById(id).get()

        // then
        Assertions.assertThat(post.id).isEqualTo(id)
    }

    @Test
    @Order(4)
    @DisplayName("user를 삭제한다.")
    fun test_delete_user() {
        // given
        val id = saveId!!

        // when
        userRepository.deleteById(id)
        val policies = userRepository.findByIdOrNull(id)

        // then
        Assertions.assertThat(policies).isNull()
    }
}
