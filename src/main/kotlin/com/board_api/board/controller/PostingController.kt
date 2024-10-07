package com.board_api.board.controller

import com.board_api.board.dto.PostingItemDto
import com.board_api.board.entity.Posting
import com.board_api.board.entity.PostingRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/postings")
class PostingController(val postingRepository: PostingRepository) {
    @GetMapping
    fun getPostings(): String{
        return "hello world"
    }

    @PostMapping
    fun createPosting(
        @RequestBody postingReq: PostingItemDto
    ): ResponseEntity<PostingItemDto> {
        val posting = Posting(
            id = UUID.randomUUID().toString(),
            title = postingReq.title,
            content = postingReq.contents
        )
        postingRepository.save(posting)

        return ResponseEntity
            .status(201)
            .body(PostingItemDto.fromPosting(posting))
    }
}