package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.catalog.database.Products

object OrderItems : BaseTable("orderItems") {

    val orderId = reference("orderId", Orders.id)

    val productId = reference("productId", Products.id)

    val productName = varchar("productName", 255)

    val quantity = integer("quantity")

    val unitPrice = decimal("unitPrice", 10, 2)

    val totalPrice = decimal("totalPrice", 10, 2)
}