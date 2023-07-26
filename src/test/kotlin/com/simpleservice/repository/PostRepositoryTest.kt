package com.simpleservice.repository

import com.simpleservice.entity.Policy
import com.simpleservice.entity.Post
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
class PostRepositoryTest {

    @Autowired
    private lateinit var postRepository: PostRepository

    private var saveId: Long? = null

    @Test
    @Order(1)
    @DisplayName("전체 post를 조회한다.")
    fun test_find_all_post() {
        // given
        // Nothing

        // when
        val posts = postRepository.findAll()

        // then
        Assertions.assertThat(posts).isNotNull
    }

    @Test
    @Order(2)
    @DisplayName("post를 저장한다.")
    fun test_add_post() {
        // given
        val post = Post(
            name = "TEST",
            title = "TEST",
            comment = "TEST",
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis())
        )

        // when
        val savedPost = postRepository.save(post)
        saveId = savedPost.id

        // then
        Assertions.assertThat(saveId).isNotNull()
    }

    @Test
    @Order(3)
    @DisplayName("post를 가져온다.")
    fun test_get_post() {
        // given
        val id = saveId!!

        // when
        val post = postRepository.findById(id).get()

        // then
        Assertions.assertThat(post.id).isEqualTo(id)
    }

    @Test
    @Order(4)
    @DisplayName("post를 삭제한다.")
    fun test_delete_post() {
        // given
        val id = saveId!!

        // when
        postRepository.deleteById(id)
        val policies = postRepository.findByIdOrNull(id)

        // then
        Assertions.assertThat(policies).isNull()
    }
}
