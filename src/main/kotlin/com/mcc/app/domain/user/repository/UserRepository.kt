package com.mcc.app.domain.user.repository

import com.mcc.app.domain.core.BaseRepository
import com.mcc.app.domain.user.model.User

interface UserRepository : BaseRepository<User> {
    suspend fun createRead(
        data: User,
        password: String
    ): User
}