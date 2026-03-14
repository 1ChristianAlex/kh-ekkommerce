package com.mcc.app.di

import com.mcc.app.adapter.output.exposed.user.repository.UserExposedRepositoryImpl
import com.mcc.app.domain.core.PasswordService
import com.mcc.app.domain.user.repository.UserRepository
import io.ktor.server.application.*
import io.ktor.server.plugins.di.*
import org.jetbrains.exposed.v1.jdbc.Database

fun Application.appModuleDI() {
    dependencies {
        provide<UserRepository> {
            UserExposedRepositoryImpl(
                resolve<Database>(),
            )
        }
        provide(PasswordService::class)
    }
}