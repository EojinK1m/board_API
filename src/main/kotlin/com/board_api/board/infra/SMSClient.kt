package com.board_api.board.infra

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component

@Component
class SMSClient(
    private val logger: KLogger = KotlinLogging.logger {}
){
    fun sendSMS(destination: String, content: String) {
        logger.debug { "sendSMS is not implemented" }
    }
}