package com.mcc.app.adapter.output.exposed

import com.mcc.app.adapter.output.exposed.catalog.database.*
import com.mcc.app.adapter.output.exposed.order.database.*
import com.mcc.app.adapter.output.exposed.user.database.AddressesTable
import com.mcc.app.adapter.output.exposed.user.database.RolesTable
import com.mcc.app.adapter.output.exposed.user.database.UserRolesTable
import com.mcc.app.adapter.output.exposed.user.database.UsersTable
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.transaction


class MemoryConnection {

    val database = Database.connect(
        url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
        user = "root",
        driver = "org.h2.Driver",
        password = "",
    )

    companion object {
        fun getConnection(): Database {
            return MemoryConnection().database.apply {
                transaction {
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
        }
    }
}