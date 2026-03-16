package com.ekk.app.adapter.output.exposed

import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.datetime.CurrentDateTime
import org.jetbrains.exposed.v1.datetime.datetime

abstract class BaseTable(
    name: String = "",
) : IntIdTable(name, "id") {
    val createdAt = datetime("createdAt")
        .defaultExpression(CurrentDateTime)
    val updatedAt = datetime("updatedAt")
        .defaultExpression(CurrentDateTime)
}


abstract class BaseEntity(id: EntityID<Int>) : IntEntity(id) {

}