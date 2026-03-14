package com.mcc.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable

object Addresses : BaseTable("addresses") {

    val userId = reference("userId", Users.id)

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