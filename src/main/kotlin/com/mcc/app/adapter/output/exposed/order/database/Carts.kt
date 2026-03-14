package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.user.database.Users

object Carts : BaseTable("carts") {

    val userId = reference("userId", Users.id)

    val status = varchar("status", 50)

}