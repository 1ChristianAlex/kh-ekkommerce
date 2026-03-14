package com.mcc.app.domain.order.model

import kotlinx.datetime.LocalDateTime

data class Shipment(
    val id: Int,
    val orderId: Int,
    val trackingCode: String?,
    val carrier: String,
    val shippingStatus: String,
    val shippedAt: LocalDateTime?,
    val deliveredAt: LocalDateTime?
)