package com.example.easyinvest.DataAcces

import android.content.Context
import com.example.easyinvest.Domain.SettingsRepository
import com.example.easyinvest.R

class SettingsRepositoryImpl(context: Context) : SettingsRepository {

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.currency_prefs),
        Context.MODE_PRIVATE
    )
    private val _currrencyPrefName =
        context.getString(R.string.currency_prefs)

    override fun getDefaultCurrency(): String {
        return sharedPref.getString(_currrencyPrefName, "USD") ?: "USD"
    }

    override fun setDefaultCurrency(curr: String) {
        sharedPref.edit().putString(_currrencyPrefName, curr).apply()
    }
}
