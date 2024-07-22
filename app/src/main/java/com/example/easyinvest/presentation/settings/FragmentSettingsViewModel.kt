package com.example.easyinvest.presentation.settings

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.DataAcces.SettingsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentSettingsViewModel
@Inject constructor(private val settingsProvider: SettingsRepositoryImpl) : ViewModel() {
    private var _getCurrencySettings = MutableLiveData<String>().apply {
        value = settingsProvider.getDefaultCurrency()
    }
    val getCurrencySettings: LiveData<String> get() = _getCurrencySettings

    fun setCurrencySettings(curr: String) {
        settingsProvider.setDefaultCurrency(curr)
        _getCurrencySettings.value = curr
        Log.i("aaaa", getCurrencySettings.value!!)
    }
}
