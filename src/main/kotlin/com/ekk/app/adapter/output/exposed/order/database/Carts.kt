package com.ekk.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.user.database.UserEntity
import com.mcc.app.adapter.output.exposed.user.database.UsersTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object CartsTable : BaseTable("carts") {

    val userId = reference("userId", UsersTable.id)

    val status = varchar("status", 50)

}

class CartEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CartEntity>(CartsTable)

    var user by UserEntity referencedOn CartsTable.userId

    var status by CartsTable.status

    var createdAt by CartsTable.createdAt
    var updatedAt by CartsTable.updatedAt

    val items by CartItemEntity referrersOn CartItemsTable.cartId
}