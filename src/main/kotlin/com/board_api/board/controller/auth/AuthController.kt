package com.board_api.board.controller.auth

import com.board_api.board.dto.PostAuthPhoneSendResponse
import com.board_api.board.dto.PostAuthPhoneSendRequest
import com.board_api.board.service.AuthService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService,
) {
    @PostMapping("/phone/send")
    fun postPhoneSend(
        @Valid @RequestBody postPhoneSendReq:PostAuthPhoneSendRequest
    ): ResponseEntity<PostAuthPhoneSendResponse>{
        val tempExpiresIn = 180;


        val verificationCode = authService.sendPhoneVerificationCode(
            countryCode = postPhoneSendReq.countryCode,
            phoneNumber = postPhoneSendReq.phoneNumber
        )

        return ResponseEntity
            .status(201)
            .body(PostAuthPhoneSendResponse(tempExpiresIn))
    }
}