package io.github.aniokrait.androidtoybox.data.datasource

import io.github.aniokrait.androidtoybox.data.dataclass.UserInfo
import io.github.aniokrait.androidtoybox.data.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserInfoDataSource: UserInfoRepository {
    override suspend fun getUserInfo(): Flow<UserInfo> = flow {
        //TODO 実際にはサーバから取得する処理がここに入る
        emit(
            //サーバから取得した情報を元にレスポンス型をemitする。
            UserInfo(
            name = "Jason Statham",
            email = "jasonisawsome@gmail.com",
            address = "Hoge state, U.S."
            )
        )
    }
}