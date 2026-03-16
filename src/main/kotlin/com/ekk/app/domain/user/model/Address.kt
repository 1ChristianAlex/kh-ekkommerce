package com.ekk.app.domain.user.model

import kotlinx.datetime.LocalDateTime

data class Address(
    val id: Int,
    val userId: Int,
    val street: String,
    val number: String,
    val complement: String?,
    val neighborhood: String,
    val city: String,
    val state: String,
    val country: String,
    val zipCode: String,
    val isDefault: Boolean,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)