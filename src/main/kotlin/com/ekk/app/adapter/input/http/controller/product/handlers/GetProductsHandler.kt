package com.ekk.app.adapter.input.http.controller.product.handlers

import com.ekk.app.adapter.input.http.controller.product.resources.dto.NewProductInputDTO
import com.ekk.app.adapter.input.http.core.HTTPHandler

interface GetProductsHandler : HTTPHandler<NewProductInputDTO, NewProductInputDTO> {
}