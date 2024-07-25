package com.example.easyinvest.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.Domain.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentSettingsViewModel
@Inject constructor(private val settingsProvider: SettingsRepository) : ViewModel() {
    private val _currencySettings = MutableLiveData<String>().apply {
        value = settingsProvider.getDefaultCurrency()
    }
    val currencySettings: LiveData<String> get() = _currencySettings

    fun setCurrencySettings(curr: String) {
        settingsProvider.setDefaultCurrency(curr)
        _currencySettings.value = curr
    }
}
