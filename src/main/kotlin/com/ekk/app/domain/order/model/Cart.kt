package com.ekk.app.domain.order.model

import kotlinx.datetime.LocalDateTime

data class Cart(
    val id: Int,
    val userId: Int,
    val status: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)