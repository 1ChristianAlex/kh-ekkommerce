@file:OptIn(ExperimentalUuidApi::class)

package com.mcc.app.adapter.output.exposed.user.repository

import com.mcc.app.adapter.output.exposed.BaseExposedRepository
import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.adapter.output.exposed.user.mapper.toModel
import com.mcc.app.domain.user.model.User
import com.mcc.app.domain.user.repository.UserRepository
import org.jetbrains.exposed.v1.jdbc.Database
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class UserExposedRepositoryImpl(
    database: Database,
) : BaseExposedRepository<UserEntity, User>(database), UserRepository {
    override suspend fun createRead(data: User, password: String): User {
        return suspendedQuery {
            UserEntity.new {
                firstName = data.firstName
                lastName = data.lastName
                email = data.email
                passwordHash = password
                phone = data.phone
                isActive = data.isActive
            }.toModel()
        }
    }

    override suspend fun create(data: User): Int {
        return createRead(data).id
    }

    override suspend fun createRead(data: User): User {
        return createRead(data, Uuid.generateV7().toString())
    }

    override suspend fun read(id: Int): User {
        return suspendedQuery {
            UserEntity.get(id).toModel()
        }
    }

    override suspend fun update(id: Int, data: User) {
        return suspendedQuery {
            UserEntity.findByIdAndUpdate(id) {
                it.firstName = data.firstName
                it.lastName = data.lastName
                it.email = data.email
                it.passwordHash = ""
                it.phone = data.phone
                it.isActive = data.isActive
            }
        }
    }

    override suspend fun delete(id: Int) {
        return suspendedQuery {
            UserEntity.findByIdAndUpdate(id) {
                it.isActive = false
            }
        }
    }
}