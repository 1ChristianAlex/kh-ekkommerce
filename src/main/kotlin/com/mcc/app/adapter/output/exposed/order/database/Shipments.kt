package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.datetime.datetime

object Shipments : BaseTable("shipments") {

    val orderId = reference("orderId", Orders.id)

    val trackingCode = varchar("trackingCode", 255).nullable()

    val carrier = varchar("carrier", 100)

    val shippingStatus = varchar("shippingStatus", 50)

    val shippedAt = datetime("shippedAt").nullable()

    val deliveredAt = datetime("deliveredAt").nullable()
}