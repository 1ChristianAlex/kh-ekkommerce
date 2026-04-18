package com.ekk.app.adapter.output.exposed

import io.ktor.server.application.*
import io.ktor.server.plugins.di.*
import org.jetbrains.exposed.v1.jdbc.Database

fun Application.appDatabase() {
    dependencies {
        provide<Database> {
            MemoryConnection.getConnection()
        }
    }
}
