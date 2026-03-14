package com.mcc.app

import com.mcc.app.adapter.input.http.auth.configureSecurityJWT
import com.mcc.app.adapter.input.http.configureRouting
import com.mcc.app.adapter.output.exposed.appDatabase
import com.mcc.app.di.appModuleDI
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun Application.module() {
    appDatabase()
    appModuleDI()
    configureSecurityJWT()
    configureRouting()
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

