@file:OptIn(ExperimentalUuidApi::class)

package com.ekk.app.adapter.output.exposed.user.repository

import com.ekk.app.adapter.output.exposed.BaseExposedRepository
import com.ekk.app.adapter.output.exposed.user.database.AddressEntity
import com.ekk.app.adapter.output.exposed.user.database.UserEntity
import com.ekk.app.adapter.output.exposed.user.mapper.toModel
import com.ekk.app.domain.user.model.Address
import com.ekk.app.domain.user.repository.AddressRepository
import org.jetbrains.exposed.v1.jdbc.Database
import kotlin.uuid.ExperimentalUuidApi


class AddressExposedRepositoryImpl(
    database: Database,
) : BaseExposedRepository<AddressEntity, Address>(database), AddressRepository {
    override suspend fun createRead(data: Address, userId: Int): Address {
        return suspendedQuery {
            AddressEntity.new {
                street = data.street
                number = data.number
                complement = data.complement
                neighborhood = data.neighborhood
                city = data.city
                state = data.state
                country = data.country
                zipCode = data.zipCode
                isDefault = data.isDefault
                user = UserEntity.get(userId)
            }.toModel()
        }
    }

    override suspend fun read(id: Int): Address {
        return AddressEntity.get(id).toModel()
    }

    override suspend fun update(id: Int, data: Address) {
        AddressEntity.findByIdAndUpdate(id) {
            it.street = data.street
            it.number = data.number
            it.complement = data.complement
            it.neighborhood = data.neighborhood
            it.city = data.city
            it.state = data.state
            it.country = data.country
            it.zipCode = data.zipCode
            it.isDefault = data.isDefault
        }
    }

    override suspend fun delete(id: Int) {
        AddressEntity.get(id).delete()
    }
}