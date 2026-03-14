package com.mcc.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable

object Products : BaseTable("products") {

    val name = varchar("name", 255)
    val description = text("description")

    val sku = varchar("sku", 100).uniqueIndex()

    val price = decimal("price", 10, 2)
    val costPrice = decimal("costPrice", 10, 2).nullable()

    val stockQuantity = integer("stockQuantity")

    val categoryId = reference("categoryId", Categories.id)

    val isActive = bool("isActive").default(true)
}

