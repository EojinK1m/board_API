package com.board_api.board

import com.board_api.board.infra.TempVerificationCodeStore
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TempVerificationCodeStoreTest {
    private val tempVerificationCodeStore = TempVerificationCodeStore()

    @Test
    fun `인증번호 및 전화번호 저장 후 조회 되는지`() {
        val phoneNumber = "+821098761234"
        val verificationCode = "999999"

        tempVerificationCodeStore.storeVerificationCode(verificationCode, phoneNumber)

        val result = tempVerificationCodeStore.getVerificationCode(phoneNumber)
        Assertions.assertEquals(result, verificationCode)
    }

    @Test
    fun `저장하지 않은 전화번호 null 조회 되는지`() {
        val phoneNumber = "+821098761234"
        val verificationCode = "999999"

        val result = tempVerificationCodeStore.getVerificationCode(phoneNumber)
        Assertions.assertEquals(result, null)
    }
}