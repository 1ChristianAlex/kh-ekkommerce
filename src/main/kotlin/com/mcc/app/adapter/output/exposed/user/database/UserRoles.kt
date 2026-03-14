package com.mcc.app.adapter.output.exposed.user.database

import com.mcc.app.adapter.output.exposed.BaseTable

object UserRoles : BaseTable("userRoles") {

    val userId = reference("userId", Users.id)
    val roleId = reference("roleId", Roles.id)
}