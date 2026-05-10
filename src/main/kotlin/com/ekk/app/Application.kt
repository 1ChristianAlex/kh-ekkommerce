package com.ekk.app

import com.ekk.app.adapter.input.http.auth.configureSecurityJWT
import com.ekk.app.adapter.input.http.configureRouting
import com.ekk.app.di.appModuleDI
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun Application.module() {
    appModuleDI()
    configureSecurityJWT()
    configureRouting()
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

