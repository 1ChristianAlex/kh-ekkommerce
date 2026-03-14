package com.mcc.app.domain.catalog.model

import kotlinx.datetime.LocalDateTime

data class ProductReview(
    val id: Int,
    val productId: Int,
    val userId: Int,
    val rating: Int,
    val comment: String?,
    val createdAt: LocalDateTime
)