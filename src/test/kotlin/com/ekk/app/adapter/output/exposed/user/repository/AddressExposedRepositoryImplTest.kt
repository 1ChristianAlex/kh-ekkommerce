package com.ekk.app.adapter.output.exposed.user.repository

import com.ekk.app.adapter.output.exposed.MemoryConnection
import com.ekk.app.adapter.output.exposed.user.database.UserEntity
import com.ekk.app.adapter.output.exposed.user.database.UsersTable
import com.ekk.app.domain.user.model.Address
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.jetbrains.exposed.v1.core.neq
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import kotlin.test.*
import kotlin.uuid.ExperimentalUuidApi


@OptIn(ExperimentalCoroutinesApi::class, ExperimentalUuidApi::class)
class AddressExposedRepositoryImplTest {

    private val connection = MemoryConnection.getConnection()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        PrepareTestDataBase(connection)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    val instance = AddressExposedRepositoryImpl(connection)

    @Test
    fun `given address repository, register a new address to a given user id`() = runTest {
        val user = suspendTransaction(connection) {
            UserEntity.find {
                UsersTable.id neq null
            }.limit(1).first()
        }
        val addressModel = Address(
            street = "Avenue im coding",
            number = "454",
            complement = "Apartment",
            neighborhood = "Barreiro",
            city = "Belo codigo",
            state = "Gerais",
            country = "Brasil",
            zipCode = "12345678",
            userId = 0,
            id = 0,
            isDefault = true,
            createdAt = null,
            updatedAt = null
        )
        val result = instance.createRead(
            addressModel,
            user.id.value,
        )

        assertEquals(result.city, addressModel.city)
        assertEquals(result.userId, user.id.value)
        assertNotNull(result.id)
    }
}