package com.example.easyinvest.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easyinvest.domain.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class FragmentSettingsViewModel
@Inject constructor(private val settingsProvider: SettingsRepository) : ViewModel() {
    private val _currencySettings = MutableLiveData<String>()
    val currencySettings: LiveData<String> get() = _currencySettings

    init {
        loadCurrencySettings()
    }

    private fun loadCurrencySettings() {
        viewModelScope.launch {
            _currencySettings.value = settingsProvider.getDefaultCurrency()
        }
    }

    fun setCurrencySettings(curr: String) {
        viewModelScope.launch {
            settingsProvider.setDefaultCurrency(curr)
            _currencySettings.value = curr
        }
    }
}
