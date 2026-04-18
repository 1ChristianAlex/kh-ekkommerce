package com.ekk.app.domain.user.repository

import com.ekk.app.domain.core.BaseDelete
import com.ekk.app.domain.core.BaseRead
import com.ekk.app.domain.core.BaseUpdate
import com.ekk.app.domain.user.model.Address

interface AddressRepository :
    BaseRead<Address>,
    BaseUpdate<Address>,
    BaseDelete {
    suspend fun createRead(
        data: Address,
        userId: Int
    ): Address
}