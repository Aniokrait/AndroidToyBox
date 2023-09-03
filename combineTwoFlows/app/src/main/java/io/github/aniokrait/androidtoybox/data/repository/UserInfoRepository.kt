package io.github.aniokrait.androidtoybox.data.repository

import io.github.aniokrait.androidtoybox.data.dataclass.UserInfo
import kotlinx.coroutines.flow.Flow

interface UserInfoRepository {
    suspend fun getUserInfo(): Flow<UserInfo>
}