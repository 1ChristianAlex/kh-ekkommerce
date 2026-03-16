package com.ekk.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.catalog.database.ProductReviewEntity
import com.mcc.app.adapter.output.exposed.catalog.database.ProductReviewsTable
import com.mcc.app.adapter.output.exposed.order.database.OrderEntity
import com.mcc.app.adapter.output.exposed.order.database.OrdersTable
import com.mcc.app.domain.user.model.Role
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object UsersTable : BaseTable("users") {
    val firstName = varchar("firstName", 100)
    val lastName = varchar("lastName", 100)

    val email = varchar("email", 255).uniqueIndex()
    val password = varchar("passwordHash", 255)

    val phone = varchar("phone", 30).nullable()

    val isActive = bool("isActive").default(true)
    val role = enumeration("role", Role::class).default(Role.CLIENT)

}

class UserEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserEntity>(UsersTable)

    var firstName by UsersTable.firstName
    var lastName by UsersTable.lastName
    var email by UsersTable.email
    var password by UsersTable.password
    var phone by UsersTable.phone
    var isActive by UsersTable.isActive
    var createdAt by UsersTable.createdAt
    var updatedAt by UsersTable.updatedAt
    var role by UsersTable.role

    val addresses by AddressEntity referrersOn AddressTable.userId
    val orders by OrderEntity referrersOn OrdersTable.userId
    val reviews by ProductReviewEntity referrersOn ProductReviewsTable.userId
}