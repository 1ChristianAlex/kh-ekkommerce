package com.ekk.app.adapter.input.http

import com.ekk.app.adapter.input.http.core.AppRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.di.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.slf4j.event.Level

@OptIn(ExperimentalSerializationApi::class)
fun Application.configureRouting() {
    install(ContentNegotiation) {
        json()
    }
    install(Resources)
    install(RequestValidation) {
        validate<String> { bodyText ->
            if (!bodyText.startsWith("Hello"))
                ValidationResult.Invalid("Body text should start with 'Hello'")
            else ValidationResult.Valid
        }
    }
    install(RoutingRoot) {
    }
    install(CallLogging) {
        level = Level.DEBUG
    }
    routing {
        val appRoutingList: List<AppRouting> by dependencies
        appRoutingList.forEach {
            it.map(this)
        }
    }
}
