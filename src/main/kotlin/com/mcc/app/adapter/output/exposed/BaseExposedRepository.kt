package com.mcc.app.adapter.output.exposed

import com.mcc.app.application.core.BaseRepository
import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

abstract class BaseExposedRepository<T : Table, Model>(private val database: Database, table: T) :
    BaseRepository<Model> {
    init {
        transaction(database) {
            SchemaUtils.create(table)
        }
    }

    abstract override suspend fun create(data: Model): Int
    abstract override suspend fun read(id: Int): Model?
    abstract override suspend fun update(id: Int, data: Model)
    abstract override suspend fun delete(id: Int)

    suspend fun <T> suspendedQuery(block: suspend () -> T): T = suspendTransaction(database) { block() }
}

fun <T : Any> EntityID<T>.data(): T {
    return this.value
}
