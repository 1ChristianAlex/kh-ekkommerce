package com.ekk.app.adapter.output.exposed

import io.ktor.server.plugins.di.*
import org.jetbrains.exposed.v1.jdbc.Database

fun appDatabase(dependencies: DependencyRegistry) {
    with(dependencies) {
        provide<Database> {
            MemoryConnection.getConnection()
        }
    }
}
