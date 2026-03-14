package com.mcc.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object CategoriesTable : BaseTable("categories") {

    val name = varchar("name", 150)
    val description = varchar("description", 500).nullable()

    val parentCategoryId = reference("parentCategoryId", CategoriesTable.id).nullable()
}


class CategoryEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CategoryEntity>(CategoriesTable)

    var name by CategoriesTable.name
    var description by CategoriesTable.description
    var parentCategory by CategoryEntity optionalReferencedOn CategoriesTable.parentCategoryId

    val products by ProductEntity referrersOn ProductsTable.categoryId

    var createdAt by CategoriesTable.createdAt
    var updatedAt by CategoriesTable.updatedAt
}