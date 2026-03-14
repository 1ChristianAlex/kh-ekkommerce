package com.mcc.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable

object ProductImages : BaseTable("productImages") {

    val productId = reference("productId", Products.id)

    val imageUrl = varchar("imageUrl", 500)
    val altText = varchar("altText", 255).nullable()

    val isPrimary = bool("isPrimary").default(false)

    val sortOrder = integer("sortOrder").default(0)

}