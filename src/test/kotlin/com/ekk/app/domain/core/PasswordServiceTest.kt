package com.ekk.app.domain.core

import kotlin.test.Test
import kotlin.test.assertTrue


class PasswordServiceTest {

    @Test
    fun `given password hasher hash and verify the string`() {
        val password = "1231@#15Hello"

        val result = PasswordService.hash(password)

        assertTrue(PasswordService.verify(password, result))
    }
}