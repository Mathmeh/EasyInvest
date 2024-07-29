package com.example.easyinvest.di

import com.example.easyinvest.DataAcces.AssetRepositoryImpl
import com.example.easyinvest.DataAcces.SettingsRepositoryImpl
import com.example.easyinvest.Domain.AssetsRepository
import com.example.easyinvest.Domain.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    fun bindSettingsRepository(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository

    @Binds
    fun bindAssetRepository(
        assetRepositoryImpl: AssetRepositoryImpl
    ): AssetsRepository
}
