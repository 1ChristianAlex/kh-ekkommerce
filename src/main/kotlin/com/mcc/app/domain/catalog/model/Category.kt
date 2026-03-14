package com.mcc.app.domain.catalog.model

import kotlinx.datetime.LocalDateTime

data class Category(
    val id: Int,
    val name: String,
    val description: String?,
    val parentCategoryId: Int?,
    val createdAt: LocalDateTime
)