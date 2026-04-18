package com.ekk.app.adapter.output.exposed.order.database

import com.ekk.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass
import org.jetbrains.exposed.v1.datetime.datetime

object PaymentsTable : BaseTable("payments") {

    val orderId = reference("orderId", OrdersTable.id)

    val paymentMethod = varchar("paymentMethod", 50)

    val paymentStatus = varchar("paymentStatus", 50)

    val transactionId = varchar("transactionId", 255).nullable()

    val amount = decimal("amount", 10, 2)

    val paidAt = datetime("paidAt").nullable()

}

class PaymentEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PaymentEntity>(PaymentsTable)

    var order by OrderEntity referencedOn PaymentsTable.orderId

    var paymentMethod by PaymentsTable.paymentMethod
    var paymentStatus by PaymentsTable.paymentStatus

    var transactionId by PaymentsTable.transactionId

    var amount by PaymentsTable.amount

    var paidAt by PaymentsTable.paidAt

    var createdAt by PaymentsTable.createdAt
    var updatedAt by PaymentsTable.updatedAt
}