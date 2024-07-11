package com.example.easyinvest.presentation.settings.SettingsProvider

interface ISettingsProvider {
    public fun getDefaultCurrency(): String
    public fun setDefaultCurrency(curr: String)
}
