package com.mcc.app.domain.user.model

import kotlinx.datetime.LocalDateTime

data class Role(
    val id: Int,
    val name: String,
    val description: String?,
    val createdAt: LocalDateTime
)