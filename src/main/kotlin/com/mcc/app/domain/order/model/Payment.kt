package com.mcc.app.domain.order.model

import kotlinx.datetime.LocalDateTime
import java.math.BigDecimal

data class Payment(
    val id: Int,
    val orderId: Int,
    val paymentMethod: String,
    val paymentStatus: String,
    val transactionId: String?,
    val amount: BigDecimal,
    val paidAt: LocalDateTime?,
    val createdAt: LocalDateTime
)