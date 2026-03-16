package com.ekk.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass
import org.jetbrains.exposed.v1.datetime.datetime

object ShipmentsTable : BaseTable("shipments") {

    val orderId = reference("orderId", OrdersTable.id)

    val trackingCode = varchar("trackingCode", 255).nullable()

    val carrier = varchar("carrier", 100)

    val shippingStatus = varchar("shippingStatus", 50)

    val shippedAt = datetime("shippedAt").nullable()

    val deliveredAt = datetime("deliveredAt").nullable()
}

class ShipmentEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ShipmentEntity>(ShipmentsTable)

    var order by OrderEntity referencedOn ShipmentsTable.orderId

    var trackingCode by ShipmentsTable.trackingCode

    var carrier by ShipmentsTable.carrier

    var shippingStatus by ShipmentsTable.shippingStatus

    var shippedAt by ShipmentsTable.shippedAt
    var deliveredAt by ShipmentsTable.deliveredAt
    var createdAt by ShipmentsTable.createdAt
    var updatedAt by ShipmentsTable.updatedAt
}