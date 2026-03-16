package com.ekk.app.domain.catalog.model

import kotlinx.datetime.LocalDateTime

data class ProductImage(
    val id: Int,
    val productId: Int,
    val imageUrl: String,
    val altText: String?,
    val isPrimary: Boolean,
    val sortOrder: Int,
    val createdAt: LocalDateTime
)