@file:OptIn(ExperimentalUuidApi::class)

package com.mcc.app.domain.user.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid


class UserTest {
    @Test
    fun `given User model instance when phone getter is called return only numbers`() {
        val user = User(
            firstName = Uuid.generateV7().toString(),
            lastName = Uuid.generateV7().toString(),
            email = Uuid.generateV7().toString(),
            _phone = "(31) 9 9999-9898",
            id = 1,
            isActive = true,
            createdAt = null,
            updatedAt = null
        )

        assertEquals(user.phone, "31999999898")
    }
}