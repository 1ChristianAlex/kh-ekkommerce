package com.mcc.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.order.database.ShipmentsTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object AddressesTable : BaseTable("addresses") {

    val userId = reference("userId", UsersTable.id)

    val street = varchar("street", 255)
    val number = varchar("number", 20)

    val complement = varchar("complement", 100).nullable()
    val neighborhood = varchar("neighborhood", 100)

    val city = varchar("city", 100)
    val state = varchar("state", 100)
    val country = varchar("country", 100)

    val zipCode = varchar("zipCode", 20)

    val isDefault = bool("isDefault").default(false)
}

class AddressEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AddressEntity>(AddressesTable)

    var user by UserEntity referencedOn AddressesTable.userId

    var street by AddressesTable.street
    var number by AddressesTable.number
    var complement by AddressesTable.complement
    var neighborhood by AddressesTable.neighborhood
    var city by AddressesTable.city
    var state by AddressesTable.state
    var country by AddressesTable.country
    var zipCode by AddressesTable.zipCode

    var isDefault by AddressesTable.isDefault

    var createdAt by AddressesTable.createdAt
    var updatedAt by AddressesTable.updatedAt
}