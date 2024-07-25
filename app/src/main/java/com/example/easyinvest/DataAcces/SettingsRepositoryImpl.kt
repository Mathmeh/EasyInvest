package com.example.easyinvest.DataAcces

import android.content.Context
import com.example.easyinvest.Domain.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepositoryImpl
@Inject constructor(@ApplicationContext context: Context) : SettingsRepository {
    val sharedPref = context.getSharedPreferences(
        DEFAULT_CURRENCY_PREF_KEY, Context.MODE_PRIVATE
    )

    override fun getDefaultCurrency(): String {
        return sharedPref.getString(DEFAULT_CURRENCY_PREF_KEY, "USD") ?: "USD"
    }

    override fun setDefaultCurrency(curr: String) {
        sharedPref.edit().putString(DEFAULT_CURRENCY_PREF_KEY, curr).apply()
    }

    companion object {
        const val DEFAULT_CURRENCY_PREF_KEY = "currency_prefs"
    }
}
