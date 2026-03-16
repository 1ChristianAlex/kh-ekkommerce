package com.ekk.app.adapter.output.exposed.user.mapper

import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.domain.user.model.User
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction

suspend fun UserEntity.toModel(): User {
    val userId = id.value
    return suspendTransaction {
        User(
            firstName = firstName,
            lastName = lastName,
            email = email,
            _phone = phone,
            isActive = isActive,
            id = userId,
            createdAt = createdAt,
            updatedAt = updatedAt,
            role = role,
            address = addresses.map { it.toModel() }
        )
    }
}