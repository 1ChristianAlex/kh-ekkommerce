package com.ekk.app.adapter.input.http.controller.product.handlers

import com.ekk.app.adapter.input.http.controller.product.resources.dto.NewProductInputDTO
import com.ekk.app.adapter.input.http.core.HTTPResult
import io.ktor.http.*

class GetProductsHandlerImpl : GetProductsHandler {
    override suspend fun handler(body: NewProductInputDTO): HTTPResult<NewProductInputDTO> {
        return HTTPResult(body, HttpStatusCode.Created)
    }
}