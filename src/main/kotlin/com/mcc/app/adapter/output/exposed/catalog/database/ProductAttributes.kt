package com.mcc.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.ReferenceOption

object ProductAttributes : BaseTable("productAttributes") {

    val productId = reference(
        name = "productId",
        refColumn = Products.id,
        onDelete = ReferenceOption.CASCADE
    )

    val attributeName = varchar("attributeName", 100)

    val attributeValue = varchar("attributeValue", 255)
}