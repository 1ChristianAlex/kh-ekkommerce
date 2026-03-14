package com.mcc.app.adapter.output.exposed

import com.mcc.app.adapter.output.exposed.catalog.database.Categories
import com.mcc.app.adapter.output.exposed.catalog.database.ProductImages
import com.mcc.app.adapter.output.exposed.catalog.database.ProductReviews
import com.mcc.app.adapter.output.exposed.catalog.database.Products
import com.mcc.app.adapter.output.exposed.order.database.*
import com.mcc.app.adapter.output.exposed.user.database.Addresses
import com.mcc.app.adapter.output.exposed.user.database.Roles
import com.mcc.app.adapter.output.exposed.user.database.UserRoles
import com.mcc.app.adapter.output.exposed.user.database.Users
import io.ktor.server.application.*
import io.ktor.server.plugins.di.*
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun Application.appDatabase() {
    dependencies {
        provide<Database> {
            MemoryConnection().database
        }
    }
    initTables()
}

private fun Application.initTables() {
    val database: Database by dependencies
    transaction(database) {
        SchemaUtils.create(
            Users,
            Roles,
            UserRoles,
            Addresses,
            Categories,
            Products,
            ProductImages,
            Carts,
            CartItems,
            Orders,
            OrderItems,
            Payments,
            Shipments,
            ProductReviews
        )
    }
}