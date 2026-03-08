package com.board_api.board.service

import org.springframework.stereotype.Component

@Component
class VerificationCodeGenerator {
    fun generate():String{
        return (100000..999999).random().toString()
    }
}