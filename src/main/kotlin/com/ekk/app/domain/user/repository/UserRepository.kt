package com.ekk.app.domain.user.repository

import com.mcc.app.domain.core.BaseDelete
import com.mcc.app.domain.core.BaseRead
import com.mcc.app.domain.core.BaseUpdate
import com.mcc.app.domain.user.model.User

interface UserRepository :
    BaseRead<User>,
    BaseUpdate<User>,
    BaseDelete {
    suspend fun createRead(
        data: User,
        password: String
    ): User
}