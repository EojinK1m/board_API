package com.board_api.board

import com.board_api.board.dto.PostingItemDto
import com.board_api.board.entity.PostingRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") // TODO 없으면 테스트 resource 오버라이딩 안되는 것 같은데 왜인지 확인
class BoardApplicationTests @Autowired constructor(
	private val mockMvc: MockMvc,
	private val objectMapper: ObjectMapper,
	private val postingRepository: PostingRepository
){

	@Test
	fun contextLoads() {
	}
	// TODO 적절한 위치 찾기
	fun Any.toJson(): String = objectMapper.writeValueAsString(this)
	@Test
	fun `포스팅 API 정상 생성 테스트`(){
		val body = PostingItemDto(
			title = "테스트 포스팅 타이틀",
			contents = "테스트 포스팅 컨텐츠입니다."
		)
		mockMvc.perform(
			post("/api/v1/postings")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body.toJson())
		)
			.andExpect { status().is2xxSuccessful }
			.andDo { print() }

		val savedPostings = postingRepository.findAll()
		assertThat(savedPostings)
			.hasSize(1)
			.first()
			.satisfies( { posting ->
				assertThat(posting.title).isEqualTo(body.title)
				assertThat(posting.content).isEqualTo(body.contents)
			})
	}
}
