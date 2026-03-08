package com.board_api.board

import com.board_api.board.infra.SMSClient
import com.board_api.board.infra.VerificationCodeStore
import com.board_api.board.service.AuthService
import com.board_api.board.service.VerificationCodeGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

@ExtendWith(MockitoExtension::class)
class AuthServiceTest {
    @Mock
    lateinit var verificationCodeStore: VerificationCodeStore
    @Mock
    lateinit var verificationCodeGenerator: VerificationCodeGenerator
    @Mock
    lateinit var smsClient: SMSClient
    @InjectMocks
    lateinit var authService: AuthService

    @Test
    fun `인증코드 발송 시 redis에 저장 및 sms 발송`() {
        val phoneNumber = "1012341234"
        val countyCode = "+82"
        val fullPhoneNumber = countyCode+phoneNumber
        val verificationCode = "100000"

        `when`(verificationCodeGenerator.generate()).thenReturn(verificationCode)

        authService.sendPhoneVerificationCode(
            countryCode = countyCode,
            phoneNumber = phoneNumber
        )

        verify(verificationCodeStore, times(1))
            .storeVerificationCode(verificationCode, fullPhoneNumber)
        verify(smsClient, times(1))
            .sendSMS(fullPhoneNumber, verificationCode)

    }

}