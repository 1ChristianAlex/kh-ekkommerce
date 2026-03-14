package com.mcc.app.domain.catalog.model


enum class ProductStatus { DRAFT, ACTIVE, INACTIVE }

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val sku: String,
    val subtitle: String,
    val shortDescription: String,
    val brand: BrandProduct,
    val categories: List<CategoryProduct>,
    val attributes: List<AttributesProduct>,
    val price: Double,
    val currency: String,
    val media: List<FileProduct>,
    val inventory: Int,
    val status: ProductStatus
)

data class BrandProduct(
    val id: Int,
    val name: String,
)

data class CategoryProduct(
    val id: Int,
    val name: String,
)

data class AttributesProduct(
    val id: Int,
    val name: String,
)

data class FileProduct(
    val id: Int,
    val name: String,
    val url: String,
)