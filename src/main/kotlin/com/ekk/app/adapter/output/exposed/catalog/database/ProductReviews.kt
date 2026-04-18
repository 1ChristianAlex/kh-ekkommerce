package com.ekk.app.adapter.output.exposed.catalog.database

import com.ekk.app.adapter.output.exposed.BaseTable
import com.ekk.app.adapter.output.exposed.user.database.UserEntity
import com.ekk.app.adapter.output.exposed.user.database.UsersTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object ProductReviewsTable : BaseTable("productReviews") {

    val productId = reference("productId", ProductsTable.id)

    val userId = reference("userId", UsersTable.id)

    val rating = integer("rating")

    val comment = text("comment").nullable()
}

class ProductReviewEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ProductReviewEntity>(ProductReviewsTable)

    var product by ProductEntity referencedOn ProductReviewsTable.productId

    var user by UserEntity referencedOn ProductReviewsTable.userId

    var rating by ProductReviewsTable.rating

    var comment by ProductReviewsTable.comment
    var createdAt by ProductReviewsTable.createdAt
    var updatedAt by ProductReviewsTable.updatedAt
}