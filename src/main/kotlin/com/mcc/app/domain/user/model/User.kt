package com.mcc.app.domain.user.model

import kotlinx.datetime.LocalDateTime

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    private val _phone: String?,
    val isActive: Boolean,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    val phone: String
        get() {
            return _phone?.replace(Regex("\\D"), "") ?: ""
        }
}


