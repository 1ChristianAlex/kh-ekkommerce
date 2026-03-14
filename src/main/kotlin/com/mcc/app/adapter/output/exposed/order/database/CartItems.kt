package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.catalog.database.ProductEntity
import com.mcc.app.adapter.output.exposed.catalog.database.ProductReviewsTable
import com.mcc.app.adapter.output.exposed.catalog.database.ProductsTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object CartItemsTable : BaseTable("cartItems") {

    val cartId = reference("cartId", CartsTable.id)

    val productId = reference("productId", ProductsTable.id)

    val quantity = integer("quantity")

    val unitPrice = decimal("unitPrice", 10, 2)

}


class CartItemEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CartItemEntity>(CartItemsTable)

    var cart by CartEntity referencedOn CartItemsTable.cartId

    var product by ProductEntity referencedOn CartItemsTable.productId

    var quantity by CartItemsTable.quantity

    var unitPrice by CartItemsTable.unitPrice

    var createdAt by CartItemsTable.createdAt
    var updatedAt by CartItemsTable.updatedAt
}