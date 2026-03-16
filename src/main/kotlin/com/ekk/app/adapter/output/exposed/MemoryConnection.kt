package com.ekk.app.adapter.output.exposed

import com.mcc.app.adapter.output.exposed.catalog.database.*
import com.mcc.app.adapter.output.exposed.order.database.*
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
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.user.database.UsersTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.catalog.database.ProductAttributesTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.user.database.AddressTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.order.database.OrderStatusHistoryTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.catalog.database.CategoriesTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.catalog.database.ProductsTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.catalog.database.ProductImagesTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.order.database.CartsTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.order.database.CartItemsTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.order.database.OrdersTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.order.database.OrderItemsTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.order.database.PaymentsTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.order.database.ShipmentsTable,
                        _root_ide_package_.com.ekk.app.adapter.output.exposed.catalog.database.ProductReviewsTable
                    )
                }
            }
        }
    }
}