package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.user.database.Users
import org.jetbrains.exposed.v1.core.ReferenceOption

object OrderStatusHistory : BaseTable("orderStatusHistory") {

    val orderId = reference(
        name = "orderId", refColumn = Orders.id, onDelete = ReferenceOption.CASCADE
    )

    val status = varchar("status", 50)

    val changedByUserId = reference(
        name = "changedByUserId", refColumn = Users.id
    ).nullable()

    val note = varchar("note", 500).nullable()
}