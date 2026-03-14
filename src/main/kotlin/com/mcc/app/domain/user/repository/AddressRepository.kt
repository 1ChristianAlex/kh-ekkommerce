package com.mcc.app.domain.user.repository

import com.mcc.app.domain.core.BaseDelete
import com.mcc.app.domain.core.BaseRead
import com.mcc.app.domain.core.BaseUpdate
import com.mcc.app.domain.user.model.Address

interface AddressRepository :
    BaseRead<Address>,
    BaseUpdate<Address>,
    BaseDelete {
    suspend fun createRead(
        data: Address,
        userId: Int
    ): Address
}