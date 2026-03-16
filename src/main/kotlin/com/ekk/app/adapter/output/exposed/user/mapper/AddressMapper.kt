package com.ekk.app.adapter.output.exposed.user.mapper

import com.mcc.app.adapter.output.exposed.user.database.AddressEntity
import com.mcc.app.domain.user.model.Address

fun AddressEntity.toModel(): Address {
    return Address(
        id = this.id.value,
        userId = this.user.id.value,
        street = this.street,
        number = this.number,
        complement = this.complement,
        neighborhood = this.neighborhood,
        city = this.city,
        state = this.state,
        country = this.country,
        zipCode = this.zipCode,
        isDefault = this.isDefault,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}