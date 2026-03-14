package com.mcc.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable
import com.mcc.app.adapter.output.exposed.user.database.Users

object ProductReviews : BaseTable("productReviews") {

    val productId = reference("productId", Products.id)

    val userId = reference("userId", Users.id)

    val rating = integer("rating")

    val comment = text("comment").nullable()
}