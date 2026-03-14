package com.mcc.app.adapter.output.exposed.order.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.user.database.Addresses
import com.mcc.app.adapter.output.exposed.user.database.Users
import java.math.BigDecimal

object Orders : BaseTable("orders") {

    val userId = reference("userId", Users.id)

    val addressId = reference("addressId", Addresses.id)

    val status = varchar("status", 50)

    val totalAmount = decimal("totalAmount", 10, 2)

    val shippingCost = decimal("shippingCost", 10, 2)

    val discountAmount = decimal("discountAmount", 10, 2).default(BigDecimal.ZERO)
}