package com.ekk.app.adapter.input.http.core

import io.ktor.server.routing.*

interface AppRouting {
    fun map(
        routing: Routing
    ): Unit
}

