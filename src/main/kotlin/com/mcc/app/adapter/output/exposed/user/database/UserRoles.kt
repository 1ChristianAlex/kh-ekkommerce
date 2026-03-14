package com.mcc.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object UserRolesTable : BaseTable("userRoles") {

    val userId = reference("userId", UsersTable.id)
    val roleId = reference("roleId", RolesTable.id)
}

class UserRoleEntity(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<UserRoleEntity>(UserRolesTable)

    var user by UserEntity referencedOn UserRolesTable.userId

    var role by RoleEntity referencedOn UserRolesTable.roleId
    var createdAt by UserRolesTable.createdAt
    var updatedAt by UserRolesTable.updatedAt
}