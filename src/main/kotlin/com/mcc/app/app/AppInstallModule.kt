package com.mcc.app.app

import com.mcc.app.adapter.input.http.auth.configureSecurityJWT
import com.mcc.app.adapter.input.http.configureRouting
import com.mcc.app.adapter.output.exposed.appDatabase
import com.mcc.app.di.appModuleDI
import io.ktor.server.application.*

fun Application.module() {
    appDatabase()
    appModuleDI()
    configureSecurityJWT()
    configureRouting()
}
