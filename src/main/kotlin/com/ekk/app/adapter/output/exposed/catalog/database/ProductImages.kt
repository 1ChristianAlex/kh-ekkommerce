package com.ekk.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object ProductImagesTable : BaseTable("productImages") {

    val productId = reference("productId", ProductsTable.id)

    val imageUrl = varchar("imageUrl", 500)
    val altText = varchar("altText", 255).nullable()

    val isPrimary = bool("isPrimary").default(false)

    val sortOrder = integer("sortOrder").default(0)

}

class ProductImageEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ProductImageEntity>(ProductImagesTable)

    var product by ProductEntity referencedOn ProductImagesTable.productId

    var imageUrl by ProductImagesTable.imageUrl
    var altText by ProductImagesTable.altText
    var isPrimary by ProductImagesTable.isPrimary
    var sortOrder by ProductImagesTable.sortOrder

    var createdAt by ProductImagesTable.createdAt
    var updatedAt by ProductImagesTable.updatedAt
}