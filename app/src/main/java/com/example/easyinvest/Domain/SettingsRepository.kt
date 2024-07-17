package com.example.easyinvest.Domain

interface SettingsRepository {
    fun getDefaultCurrency(): String
    fun setDefaultCurrency(curr: String)
}
