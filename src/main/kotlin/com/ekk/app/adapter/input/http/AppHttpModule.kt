package com.ekk.app.adapter.input.http


import com.ekk.app.adapter.input.http.controller.product.ProductRouting
import com.ekk.app.adapter.input.http.controller.product.handlers.GetProductsHandler
import com.ekk.app.adapter.input.http.controller.product.handlers.GetProductsHandlerImpl
import com.ekk.app.adapter.input.http.core.AppRouting
import com.ekk.app.adapter.input.http.core.ControllerToRoute
import io.ktor.server.plugins.di.*

fun appHttpModule(dependencies: DependencyRegistry) {
    with(dependencies) {
        provide(ProductRouting::class)
        provide(ControllerToRoute::class)

        provide<GetProductsHandler>(GetProductsHandlerImpl::class)

        provide<List<AppRouting>> {
            listOf<AppRouting>(resolve<ProductRouting>())
        }
    }
}