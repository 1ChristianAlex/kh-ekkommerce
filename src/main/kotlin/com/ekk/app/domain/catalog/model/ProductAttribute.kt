package com.ekk.app.domain.catalog.model

import kotlinx.datetime.LocalDateTime

data class ProductAttribute(
    val id: Int,
    val productId: Int,
    val attributeName: String,
    val attributeValue: String,
    val createdAt: LocalDateTime
)