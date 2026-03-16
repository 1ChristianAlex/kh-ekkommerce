package com.ekk.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.catalog.database.ProductEntity
import com.mcc.app.adapter.output.exposed.catalog.database.ProductsTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object OrderItemsTable : BaseTable("orderItems") {

    val orderId = reference("orderId", OrdersTable.id)

    val productId = reference("productId", ProductsTable.id)

    val productName = varchar("productName", 255)

    val quantity = integer("quantity")

    val unitPrice = decimal("unitPrice", 10, 2)

    val totalPrice = decimal("totalPrice", 10, 2)
}

class OrderItemEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<OrderItemEntity>(OrderItemsTable)

    var order by OrderEntity referencedOn OrderItemsTable.orderId

    var product by ProductEntity referencedOn OrderItemsTable.productId

    var productName by OrderItemsTable.productName

    var quantity by OrderItemsTable.quantity

    var unitPrice by OrderItemsTable.unitPrice

    var totalPrice by OrderItemsTable.totalPrice

    var createdAt by OrderItemsTable.createdAt
    var updatedAt by OrderItemsTable.updatedAt
}
