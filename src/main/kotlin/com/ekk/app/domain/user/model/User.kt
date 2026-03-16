package com.ekk.app.domain.user.model

import kotlinx.datetime.LocalDateTime

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    private val _phone: String?,
    val isActive: Boolean,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val role: Role = Role.CLIENT,
    val address: List<Address> = emptyList()
) {
    val phone: String
        get() {
            return _phone?.replace(Regex("\\D"), "") ?: ""
        }
}


