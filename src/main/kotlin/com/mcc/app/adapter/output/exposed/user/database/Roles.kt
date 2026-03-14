package com.mcc.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object RolesTable : BaseTable("roles") {
    val name = varchar("name", 50).uniqueIndex()
    val description = varchar("description", 255).nullable()
}

class RoleEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoleEntity>(RolesTable)

    var name by RolesTable.name
    var description by RolesTable.description
    var createdAt by RolesTable.createdAt
    var updatedAt by RolesTable.updatedAt
}