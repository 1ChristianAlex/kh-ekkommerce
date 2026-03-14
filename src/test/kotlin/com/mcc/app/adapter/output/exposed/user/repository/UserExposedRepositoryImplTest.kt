package com.mcc.app.adapter.output.exposed.user.repository

import com.mcc.app.adapter.output.exposed.MemoryConnection
import com.mcc.app.domain.user.model.User
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class UserExposedRepositoryImplTest {
    val instance = UserExposedRepositoryImpl(MemoryConnection.getConnection())

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `given create method should write the data value in database`() = runTest {
        val result = instance.createRead(
            User(
                firstName = Uuid.generateV7().toString(),
                lastName = Uuid.generateV7().toString(),
                email = Uuid.generateV7().toString(),
                _phone = "(31) 9 9999-9898",
                id = 1,
                isActive = true,
                createdAt = null,
                updatedAt = null
            )
        )

        val userRegister = instance.read(1)

        assertEquals(result, userRegister)
    }
}