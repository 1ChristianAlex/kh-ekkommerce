package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.catalog.database.Products

object CartItems : BaseTable("cartItems") {

    val cartId = reference("cartId", Carts.id)

    val productId = reference("productId", Products.id)

    val quantity = integer("quantity")

    val unitPrice = decimal("unitPrice", 10, 2)

}

