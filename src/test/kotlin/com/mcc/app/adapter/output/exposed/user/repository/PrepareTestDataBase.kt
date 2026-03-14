package com.mcc.app.adapter.output.exposed.user.repository

import com.mcc.app.adapter.output.exposed.user.database.AddressEntity
import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.adapter.output.exposed.user.database.UsersTable
import com.mcc.app.domain.user.model.Role
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class PrepareTestDataBase(private val database: Database) {
    init {
        runBlocking {
            prepareEnv()
        }
    }

    private suspend fun prepareEnv() {
        prepareUserTable()
    }

    private suspend fun prepareUserTable() {
        val password = "1231@#15Hello"
        val uniqueEmail = "teste.suit.user@mail.com"

        val userExists = suspendTransaction(database) {
            UserEntity.find { UsersTable.email eq uniqueEmail }.firstOrNull()
        }

        if (userExists == null) {
            val user = suspendTransaction(database) {
                UserEntity.new {
                    firstName = Uuid.generateV7().toString()
                    lastName = Uuid.generateV7().toString()
                    email = uniqueEmail
                    this.password = password
                    phone = "31999999898"
                    isActive = true
                    role = Role.ADMIN
                }
            }

            suspendTransaction(database) {
                AddressEntity.new {
                    street = "Avenue im coding"
                    number = "454"
                    complement = "Apartment"
                    neighborhood = "Barreiro"
                    city = "Belo codigo"
                    state = "Gerais"
                    country = "Brasil"
                    zipCode = "12345678"
                    isDefault = true
                    this.user = user
                }
            }

            println("Test suit user created")
        }
    }
}