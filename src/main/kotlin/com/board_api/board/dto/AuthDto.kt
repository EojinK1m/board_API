package com.board_api.board.dto

data class PostAuthPhoneSendResponse(
    val expiresIn: Int // sec
)

data class PostAuthPhoneSendRequest(
    // validation 추가
    val countryCode: String,
    val phoneNumber: String
)