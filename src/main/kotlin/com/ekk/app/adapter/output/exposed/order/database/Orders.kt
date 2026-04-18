package com.ekk.app.adapter.output.exposed.order.database

import com.ekk.app.adapter.output.exposed.BaseTable
import com.ekk.app.adapter.output.exposed.user.database.AddressEntity
import com.ekk.app.adapter.output.exposed.user.database.AddressTable
import com.ekk.app.adapter.output.exposed.user.database.UserEntity
import com.ekk.app.adapter.output.exposed.user.database.UsersTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass
import java.math.BigDecimal

object OrdersTable : BaseTable("orders") {

    val userId = reference("userId", UsersTable.id)

    val addressId = reference("addressId", AddressTable.id)

    val status = varchar("status", 50)

    val totalAmount = decimal("totalAmount", 10, 2)

    val shippingCost = decimal("shippingCost", 10, 2)

    val discountAmount = decimal("discountAmount", 10, 2).default(BigDecimal.ZERO)
}

class OrderEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<OrderEntity>(OrdersTable)

    var user by UserEntity referencedOn OrdersTable.userId

    var address by AddressEntity referencedOn OrdersTable.addressId

    var status by OrdersTable.status

    var totalAmount by OrdersTable.totalAmount
    var shippingCost by OrdersTable.shippingCost
    var discountAmount by OrdersTable.discountAmount

    var createdAt by OrdersTable.createdAt
    var updatedAt by OrdersTable.updatedAt

    val items by OrderItemEntity referrersOn OrderItemsTable.orderId
    val payments by PaymentEntity referrersOn PaymentsTable.orderId
    val shipments by ShipmentEntity referrersOn ShipmentsTable.orderId
    val statusHistory by OrderStatusHistoryEntity referrersOn OrderStatusHistoryTable.orderId
}