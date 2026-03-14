package com.mcc.app.domain.order.model

import kotlinx.datetime.LocalDateTime
import java.math.BigDecimal

data class CartItem(
    val id: Int,
    val cartId: Int,
    val productId: Int,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val createdAt: LocalDateTime
)