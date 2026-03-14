package com.mcc.app.adapter.output.exposed.catalog.database

import com.mcc.app.adapter.output.exposed.BaseTable

object Categories : BaseTable("categories") {

    val name = varchar("name", 150)
    val description = varchar("description", 500).nullable()

    val parentCategoryId = reference("parentCategoryId", Categories.id).nullable()
}
