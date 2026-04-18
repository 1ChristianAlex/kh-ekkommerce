package com.ekk.app.domain.user.repository

import com.ekk.app.domain.core.BaseDelete
import com.ekk.app.domain.core.BaseRead
import com.ekk.app.domain.core.BaseUpdate
import com.ekk.app.domain.user.model.User

interface UserRepository :
    BaseRead<User>,
    BaseUpdate<User>,
    BaseDelete {
    suspend fun createRead(
        data: User,
        password: String
    ): User
}