package com.ekk.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.ReferenceOption
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object ProductAttributesTable : BaseTable("productAttributes") {

    val productId = reference(
        name = "productId",
        refColumn = ProductsTable.id,
        onDelete = ReferenceOption.CASCADE
    )

    val attributeName = varchar("attributeName", 100)

    val attributeValue = varchar("attributeValue", 255)
}

class ProductAttributeEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ProductAttributeEntity>(ProductAttributesTable)

    var product by ProductEntity referencedOn ProductAttributesTable.productId

    var attributeName by ProductAttributesTable.attributeName
    var attributeValue by ProductAttributesTable.attributeValue

    var createdAt by ProductAttributesTable.createdAt
    var updatedAt by ProductAttributesTable.updatedAt
}