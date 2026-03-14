package com.mcc.app.adapter.output.exposed.user.repository

import com.mcc.app.adapter.output.exposed.BaseExposedRepository
import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.adapter.output.exposed.user.database.UsersTable
import com.mcc.app.application.core.BaseRepository
import com.mcc.app.domain.user.model.User
import org.jetbrains.exposed.v1.jdbc.Database

class UserExposedRepositoryImpl(database: Database) : BaseExposedRepository<UsersTable, User>(database),
    BaseRepository<User> {
    override suspend fun create(data: User): Int {
        return suspendedQuery {
            val user = UserEntity.new {
                firstName = data.firstName
                lastName = data.lastName
                email = data.email
                passwordHash = ""
                phone = data.phone
                isActive = data.isActive
            }

            user.id.value
        }
    }

    override suspend fun read(id: Int): User {
        return suspendedQuery {
            val user = UserEntity.get(id)

            User(
                firstName = user.firstName,
                lastName = user.lastName,
                email = user.email,
                phone = user.phone,
                isActive = user.isActive,
                id = user.id.value,
                createdAt = user.createdAt,
                updatedAt = user.updatedAt
            )
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