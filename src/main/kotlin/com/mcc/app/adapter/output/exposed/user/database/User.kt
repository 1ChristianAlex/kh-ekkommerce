package com.mcc.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable

object Users : BaseTable("users") {
    val firstName = varchar("firstName", 100)
    val lastName = varchar("lastName", 100)

    val email = varchar("email", 255).uniqueIndex()
    val passwordHash = varchar("passwordHash", 255)

    val phone = varchar("phone", 30).nullable()

    val isActive = bool("isActive").default(true)
}