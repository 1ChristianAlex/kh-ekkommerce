package com.ekk.app.di

import com.ekk.app.adapter.input.http.appHttpModule
import com.ekk.app.adapter.output.exposed.appDatabase
import com.ekk.app.adapter.output.exposed.user.repository.UserExposedRepositoryImpl
import com.ekk.app.domain.core.PasswordService
import com.ekk.app.domain.user.repository.UserRepository
import io.ktor.server.application.*
import io.ktor.server.plugins.di.*

fun Application.appModuleDI() {
    appDatabase(dependencies)
    appHttpModule(dependencies)
    dependencies {
        provide<UserRepository>(UserExposedRepositoryImpl::class)
        provide(PasswordService::class)
    }
}