package com.ekk.app.adapter.output.exposed

import com.ekk.app.adapter.output.exposed.catalog.database.*
import com.ekk.app.adapter.output.exposed.order.database.*
import com.ekk.app.adapter.output.exposed.user.database.AddressTable
import com.ekk.app.adapter.output.exposed.user.database.UsersTable
import org.jetbrains.exposed.v1.core.StdOutSqlLogger
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
                        ProductAttributesTable,
                        AddressTable,
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