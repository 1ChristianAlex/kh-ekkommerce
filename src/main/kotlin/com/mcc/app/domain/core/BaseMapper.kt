package com.mcc.app.domain.core

interface BaseMapper<Input, Output> {
    fun fromModel(data: Output): Input
    fun toModel(data: Input): Output
}