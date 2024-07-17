package com.example.easyinvest.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.DataAcces.SettingsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentSettingsViewModel
@Inject constructor(private val settingsProvider: SettingsRepositoryImpl) : ViewModel() {
    private val _getCurrencySettings = MutableLiveData<String>().apply {
        value = settingsProvider.getDefaultCurrency()
    }
    val getCurrencySettings: LiveData<String> = _getCurrencySettings

    fun setCurrencySettings(curr: String) {
        settingsProvider.setDefaultCurrency(curr)
    }
}
