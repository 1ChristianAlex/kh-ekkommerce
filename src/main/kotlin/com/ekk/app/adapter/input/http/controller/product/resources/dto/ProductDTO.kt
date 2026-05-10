package com.ekk.app.adapter.input.http.controller.product.resources.dto

import com.ekk.app.adapter.input.http.core.serializers.BigDecimalSerializer
import com.ekk.app.adapter.input.http.core.serializers.CustomValidationStringSerializer
import com.ekk.app.adapter.input.http.core.serializers.MaxLengthStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

object Max255Serializer : MaxLengthStringSerializer(255)
object NotEmpty : CustomValidationStringSerializer(validators = listOf {
    if (it.trim().isEmpty()) {
        "Value can not be empty"
    } else null
})

@Serializable
data class NewProductInputDTO(
    @Serializable(with = NotEmpty::class)
    @SerialName("name")
    val name: String,
    @Serializable(with = Max255Serializer::class)
    @SerialName("description") val description: String,
    val sku: String,
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,
    @Serializable(with = BigDecimalSerializer::class)
    val costPrice: BigDecimal,
    val stockQuantity: Int,
    val categoryId: Int,
    val isActive: Boolean,
)