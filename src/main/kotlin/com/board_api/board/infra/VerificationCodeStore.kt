package com.board_api.board.infra

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component


@Component
class VerificationCodeStore(
    private val logger: KLogger = KotlinLogging.logger {}
) {
    fun storeVerificationCode(verificationCode: String, fullPhoneNumber: String) {
        logger.debug { "storeVerificationCode is not implemented" }
    }
}