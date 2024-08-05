package com.example.easyinvest.di

import com.example.easyinvest.dataAcces.AssetRepositoryImpl
import com.example.easyinvest.dataAcces.PortfolioRepositoryImpl
import com.example.easyinvest.dataAcces.SettingsRepositoryImpl
import com.example.easyinvest.domain.AssetsRepository
import com.example.easyinvest.domain.PortfolioRepository
import com.example.easyinvest.domain.SettingsRepository
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
    fun bindPortfolioRepository(
        portfolioRepositoryImpl: PortfolioRepositoryImpl
    ): PortfolioRepository

    @Binds
    fun bindAssetRepository(
        assetRepositoryImpl: AssetRepositoryImpl
    ): AssetsRepository
}
