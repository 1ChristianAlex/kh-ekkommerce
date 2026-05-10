package com.ekk.app.adapter.input.http.core


interface HTTPHandler<Body, Output> {
    suspend fun handler(body: Body): HTTPResult<Output>
}
