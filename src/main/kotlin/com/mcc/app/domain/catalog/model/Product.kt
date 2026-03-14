package com.mcc.app.domain.catalog.model

import kotlinx.datetime.LocalDateTime
import java.math.BigDecimal

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val sku: String,
    val price: BigDecimal,
    val costPrice: BigDecimal?,
    val stockQuantity: Int,
    val categoryId: Int,
    val isActive: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)