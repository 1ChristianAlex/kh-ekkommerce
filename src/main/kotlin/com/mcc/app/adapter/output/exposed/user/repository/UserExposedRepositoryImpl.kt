@file:OptIn(ExperimentalUuidApi::class)

package com.mcc.app.adapter.output.exposed.user.repository

import com.mcc.app.adapter.output.exposed.BaseExposedRepository
import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.adapter.output.exposed.user.mapper.toModel
import com.mcc.app.domain.user.model.User
import com.mcc.app.domain.user.repository.UserRepository
import org.jetbrains.exposed.v1.jdbc.Database
import kotlin.uuid.ExperimentalUuidApi

class UserExposedRepositoryImpl(
    database: Database,
) : BaseExposedRepository<UserEntity, User>(database), UserRepository {
    override suspend fun createRead(data: User, password: String): User {
        return suspendedQuery {
            UserEntity.new {
                firstName = data.firstName
                lastName = data.lastName
                email = data.email
                this.password = password
                phone = data.phone
                isActive = data.isActive
            }.toModel()
        }
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
                it.phone = data.phone
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