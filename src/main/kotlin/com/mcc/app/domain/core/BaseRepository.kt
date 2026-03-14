package com.mcc.app.domain.core

interface BaseRepository<Model> {
    suspend fun create(data: Model): Int
    suspend fun createRead(data: Model): Model
    suspend fun read(id: Int): Model?
    suspend fun update(id: Int, data: Model)
    suspend fun delete(id: Int)
}