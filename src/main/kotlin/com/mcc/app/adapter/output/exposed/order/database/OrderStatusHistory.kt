package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.adapter.output.exposed.user.database.UsersTable
import org.jetbrains.exposed.v1.core.ReferenceOption
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object OrderStatusHistoryTable : BaseTable("orderStatusHistory") {

    val orderId = reference(
        name = "orderId", refColumn = OrdersTable.id, onDelete = ReferenceOption.CASCADE
    )

    val status = varchar("status", 50)

    val changedByUserId = reference(
        name = "changedByUserId", refColumn = UsersTable.id
    ).nullable()

    val note = varchar("note", 500).nullable()
}

class OrderStatusHistoryEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<OrderStatusHistoryEntity>(OrderStatusHistoryTable)

    var order by OrderEntity referencedOn OrderStatusHistoryTable.orderId

    var status by OrderStatusHistoryTable.status

    var changedByUser by UserEntity optionalReferencedOn OrderStatusHistoryTable.changedByUserId

    var note by OrderStatusHistoryTable.note


    var createdAt by OrderStatusHistoryTable.createdAt
    var updatedAt by OrderStatusHistoryTable.updatedAt
}