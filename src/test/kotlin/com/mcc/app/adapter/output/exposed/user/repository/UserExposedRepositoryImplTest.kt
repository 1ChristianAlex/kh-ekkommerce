package com.mcc.app.adapter.output.exposed.user.repository

import com.mcc.app.adapter.output.exposed.MemoryConnection
import com.mcc.app.domain.user.model.Role
import com.mcc.app.domain.user.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class, ExperimentalCoroutinesApi::class)
class UserExposedRepositoryImplTest {

    private val connection = MemoryConnection.getConnection()

    @BeforeTest
    fun setUp() {
        PrepareTestDataBase(connection)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }


    val instance = UserExposedRepositoryImpl(connection)
    private val password = "1231@#15Hello"

    @Test
    fun `given create method should write the data value in database`() = runTest {
        val result = instance.createRead(
            User(
                firstName = Uuid.generateV7().toString(),
                lastName = Uuid.generateV7().toString(),
                email = Uuid.generateV7().toString(),
                _phone = "(31) 9 9999-9898",
                id = 0,
                isActive = true,
                createdAt = null,
                updatedAt = null,
                role = Role.ADMIN
            ), password
        )

        val userRegister = instance.read(result.id)

        assertEquals(result, userRegister)
    }

    @Test
    fun `given update method should update the existing data with the new one`() = runTest {
        val result = instance.createRead(
            User(
                firstName = Uuid.generateV7().toString(),
                lastName = Uuid.generateV7().toString(),
                email = Uuid.generateV7().toString(),
                _phone = "(31) 9 9999-9898",
                id = 0,
                isActive = true,
                createdAt = null,
                updatedAt = null,
                role = Role.ADMIN
            ), password
        )

        val newName = "After update"
        instance.update(result.id, result.copy(firstName = newName))

        val userAfterUpdate = instance.read(result.id)

        assertEquals(newName, userAfterUpdate.firstName)
    }

    @Test
    fun `given delete method should update the active property to false`() = runTest {
        val result = instance.createRead(
            User(
                firstName = Uuid.generateV7().toString(),
                lastName = Uuid.generateV7().toString(),
                email = Uuid.generateV7().toString(),
                _phone = "(31) 9 9999-9898",
                id = 0,
                isActive = true,
                createdAt = null,
                updatedAt = null,
                role = Role.ADMIN
            ), password
        )

        instance.delete(result.id)

        assertEquals(instance.read(result.id).isActive, false)
    }
}