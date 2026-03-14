package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.datetime.datetime

object Payments : BaseTable("payments") {

    val orderId = reference("orderId", Orders.id)

    val paymentMethod = varchar("paymentMethod", 50)

    val paymentStatus = varchar("paymentStatus", 50)

    val transactionId = varchar("transactionId", 255).nullable()

    val amount = decimal("amount", 10, 2)

    val paidAt = datetime("paidAt").nullable()

}