package com.mcc.app.domain.order.model

import kotlinx.datetime.LocalDateTime
import java.math.BigDecimal

data class Order(
    val id: Int,
    val userId: Int,
    val addressId: Int,
    val status: String,
    val totalAmount: BigDecimal,
    val shippingCost: BigDecimal,
    val discountAmount: BigDecimal,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)