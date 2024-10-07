package com.board_api.board.dto

import com.board_api.board.entity.Posting

data class PostingItemDto(
    var title: String,
    var contents: String,
) {
    companion object {
        fun fromPosting(posting: Posting): PostingItemDto {
            return PostingItemDto(title = posting.title, contents = posting.content)
        }
    }
}