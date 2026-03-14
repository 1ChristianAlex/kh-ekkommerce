package com.mcc.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object ProductsTable : BaseTable("products") {

    val name = varchar("name", 255)
    val description = text("description")

    val sku = varchar("sku", 100).uniqueIndex()

    val price = decimal("price", 10, 2)
    val costPrice = decimal("costPrice", 10, 2).nullable()

    val stockQuantity = integer("stockQuantity")

    val categoryId = reference("categoryId", CategoriesTable.id)

    val isActive = bool("isActive").default(true)
}

class ProductEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ProductEntity>(ProductsTable)

    var name by ProductsTable.name
    var description by ProductsTable.description
    var sku by ProductsTable.sku

    var price by ProductsTable.price
    var costPrice by ProductsTable.costPrice

    var stockQuantity by ProductsTable.stockQuantity

    var category by CategoryEntity referencedOn ProductsTable.categoryId

    var isActive by ProductsTable.isActive

    var createdAt by ProductsTable.createdAt
    var updatedAt by ProductsTable.updatedAt

    val images by ProductImageEntity referrersOn ProductImagesTable.productId
    val attributes by ProductAttributeEntity referrersOn ProductAttributesTable.productId
    val reviews by ProductReviewEntity referrersOn ProductReviewsTable.productId
}