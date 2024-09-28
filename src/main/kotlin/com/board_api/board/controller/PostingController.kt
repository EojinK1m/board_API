package com.board_api.board.controller

import com.board_api.board.dto.PostingItemDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/postings")
class PostingController {
    @GetMapping
    fun getPostings(): String{
        return "hello world"
    }

    @PostMapping
    fun createPosting(
        @RequestBody postingReq: PostingItemDto
    ): ResponseEntity<PostingItemDto> {
        return ResponseEntity
            .status(201)
            .body(postingReq)
    }
}