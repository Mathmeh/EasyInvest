package com.example.easyinvest.domain

interface SettingsRepository {
    suspend fun getDefaultCurrency(): String
    suspend fun setDefaultCurrency(curr: String)
}
