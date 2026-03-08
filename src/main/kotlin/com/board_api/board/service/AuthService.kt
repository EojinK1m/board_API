package com.board_api.board.service

import com.board_api.board.infra.SMSClient
import com.board_api.board.infra.VerificationCodeStore
import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service


@Service
class AuthService (
    private val verificationCodeStore: VerificationCodeStore,
    private val verificationCodeGenerator: VerificationCodeGenerator,
    private val smsClient: SMSClient,
){
    private val logger: KLogger = KotlinLogging.logger {}

    fun sendPhoneVerificationCode(countryCode: String, phoneNumber: String): String {
        val fullPhoneNumber = "$countryCode$phoneNumber"
        val verificationCode = verificationCodeGenerator.generate();

        verificationCodeStore.storeVerificationCode(
            verificationCode = verificationCode,
            fullPhoneNumber = fullPhoneNumber
        )
        smsClient.sendSMS(
            destination = fullPhoneNumber,
            content = verificationCode,
        )

        logger.debug {
           "sendPhoneVerificationCode sent $verificationCode $phoneNumber, $verificationCode"
        }
        return verificationCode
    }
}