package com.mcc.app.adapter.output.exposed.user.mapper

import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.domain.user.model.User

fun UserEntity.toModel(): User {
    return User(
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        _phone = this.phone,
        isActive = this.isActive,
        id = this.id.value,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}