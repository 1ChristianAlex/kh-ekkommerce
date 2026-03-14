package com.mcc.app.adapter.output.exposed

import com.mcc.app.adapter.output.exposed.catalog.database.*
import com.mcc.app.adapter.output.exposed.order.database.*
import com.mcc.app.adapter.output.exposed.user.database.AddressesTable
import com.mcc.app.adapter.output.exposed.user.database.RolesTable
import com.mcc.app.adapter.output.exposed.user.database.UserRolesTable
import com.mcc.app.adapter.output.exposed.user.database.UsersTable
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
            UsersTable,
            RolesTable,
            UserRolesTable,
            ProductAttributesTable,
            AddressesTable,
            OrderStatusHistoryTable,
            CategoriesTable,
            ProductsTable,
            ProductImagesTable,
            CartsTable,
            CartItemsTable,
            OrdersTable,
            OrderItemsTable,
            PaymentsTable,
            ShipmentsTable,
            ProductReviewsTable
        )
    }
}