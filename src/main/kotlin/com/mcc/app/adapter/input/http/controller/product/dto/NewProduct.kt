package com.mcc.app.adapter.input.http.controller.product.dto

import com.mcc.app.domain.catalog.model.ProductStatus
import io.ktor.resources.*

@Resource("/product")
class ProductRoute() {
    @Resource("/")
    data class NewProductInputDto(
        val name: String,
        val description: String,
        val sku: String,
        val subtitle: String,
        val shortDescription: String,
        val brand: Int,
        val categories: List<String>,
        val attributes: List<String>,
        val price: Double,
        val currency: String,
        val media: List<String>,
        val inventory: Int,
        val status: ProductStatus
    )
}