package io.github.aniokrait.androidtoybox.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.aniokrait.androidtoybox.data.datasource.UserInfoDataSource
import io.github.aniokrait.androidtoybox.data.repository.UserInfoRepository

@Module
@InstallIn(SingletonComponent::class)
object UserInfoModule {
    @Provides
    fun provideUserInfoRepository(): UserInfoRepository {
        return UserInfoDataSource()
    }
}