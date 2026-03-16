package com.ekk.app.adapter.output.exposed

import io.ktor.server.application.*
import io.ktor.server.plugins.di.*
import org.jetbrains.exposed.v1.jdbc.Database

fun Application.appDatabase() {
    dependencies {
        provide<Database> {
            _root_ide_package_.com.ekk.app.adapter.output.exposed.MemoryConnection.getConnection()
        }
    }
}
