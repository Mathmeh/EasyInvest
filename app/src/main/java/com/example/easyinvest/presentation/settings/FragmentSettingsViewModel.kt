package com.example.easyinvest.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.presentation.settings.SettingsProvider.SettingsProvider

class FragmentSettingsViewModel(val settingsProvider: SettingsProvider) : ViewModel() {

    private val _getCurrencySettings = MutableLiveData<String>().apply {
        value = settingsProvider.getDefaultCurrency()
    }
    public val getCurrencySettings: LiveData<String> = _getCurrencySettings

    public fun setCurrencySettings(curr: String) {
        settingsProvider.setDefaultCurrency(curr)
    }
}
