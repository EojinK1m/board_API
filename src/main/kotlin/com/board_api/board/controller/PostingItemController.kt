package com.board_api.board.controller

import com.board_api.board.dto.PostingItemDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/postings/{postingId}")
class PostingItemController {
    @GetMapping
    fun getPosting(
        @PathVariable postingId: String,
        @RequestParam params: Map<String, String>
    ): String {
        var posting = PostingItemDto(postingId, postingId + "contents")

        return posting.toString()
    }
}