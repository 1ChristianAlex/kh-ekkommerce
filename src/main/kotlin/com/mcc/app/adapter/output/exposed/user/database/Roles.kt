package com.mcc.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable

object Roles : BaseTable("roles") {
    val name = varchar("name", 50).uniqueIndex()
    val description = varchar("description", 255).nullable()
}