package com.ekk.app.adapter.input.http.controller.product

import com.ekk.app.adapter.input.http.controller.product.handlers.GetProductsHandler
import com.ekk.app.adapter.input.http.controller.product.resources.ProductResource
import com.ekk.app.adapter.input.http.controller.product.resources.dto.NewProductInputDTO
import com.ekk.app.adapter.input.http.core.AppRouting
import com.ekk.app.adapter.input.http.core.ControllerToRoute
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Routing
import kotlinx.serialization.ExperimentalSerializationApi

class ProductRouting(
    private val getProductsHandler: GetProductsHandler,
    private val controllerToRoute: ControllerToRoute
) : AppRouting {
    @OptIn(ExperimentalSerializationApi::class)
    override fun map(routing: Routing) {
        with(routing) {
            post<ProductResource.Product> {
                controllerToRoute.toRoute(getProductsHandler, NewProductInputDTO::class, call)
            }
            get<ProductResource> {
                call.respondText("Hellow")
            }
        }
    }
}
