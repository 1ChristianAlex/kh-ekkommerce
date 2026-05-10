package com.ekk.app.adapter.input.http.controller.product.resources

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("/products")
@Serializable
class ProductResource {

    @Serializable
    @Resource("new")
    class Product(val parent: ProductResource = ProductResource())

    @Serializable
    @Resource("{id}")
    class Id(val parent: ProductResource, val id: Int) {

        @Serializable
        @Resource("edit")
        class Edit(val parent: Id)
    }
}