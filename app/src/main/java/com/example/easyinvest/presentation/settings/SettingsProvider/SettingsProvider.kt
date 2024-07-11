package com.example.easyinvest.presentation.settings.SettingsProvider

import android.content.Context
import com.example.easyinvest.R

class SettingsProvider(val context: Context) : ISettingsProvider {

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.currency_prefs),
        Context.MODE_PRIVATE
    )
    private val _currrencyPrefName =
        context.getString(R.string.currency_prefs)

    public override fun getDefaultCurrency(): String {
        return sharedPref.getString(_currrencyPrefName, "USD") ?: "USD"
    }

    public override fun setDefaultCurrency(curr: String) {
        sharedPref.edit().putString(_currrencyPrefName, curr).apply()
    }
}
