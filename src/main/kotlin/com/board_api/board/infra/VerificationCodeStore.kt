package com.board_api.board.infra

import org.springframework.stereotype.Component


interface VerificationCodeStore {
    fun storeVerificationCode(verificationCode: String, fullPhoneNumber: String)

    fun getVerificationCode(fullPhoneNumber: String): String?
}

@Component
class TempVerificationCodeStore: VerificationCodeStore {
    private val store = HashMap<String, String>()

    override fun storeVerificationCode(verificationCode: String, fullPhoneNumber: String) {
        store[fullPhoneNumber] = verificationCode
    }

    override fun getVerificationCode(fullPhoneNumber: String): String? {
        return store[fullPhoneNumber]
    }
}