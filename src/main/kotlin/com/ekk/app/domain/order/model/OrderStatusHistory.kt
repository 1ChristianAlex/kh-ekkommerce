package com.ekk.app.domain.order.model

import kotlinx.datetime.LocalDateTime

data class OrderStatusHistory(
    val id: Int,
    val orderId: Int,
    val status: String,
    val changedByUserId: Int?,
    val note: String?,
    val createdAt: LocalDateTime
)