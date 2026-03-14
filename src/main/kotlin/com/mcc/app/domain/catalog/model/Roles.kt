package com.mcc.app.domain.catalog.model

import kotlinx.serialization.Serializable

@Serializable
data class Roles(
    val id: Int,
    val name: String,
    val description: String
)