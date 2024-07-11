package com.example.easyinvest.di

import com.example.easyinvest.presentation.settings.FragmentSettingsViewModel
import com.example.easyinvest.presentation.settings.SettingsProvider.SettingsProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<SettingsProvider> {
        SettingsProvider(context = get())
    }
}
val appModule = module {
    viewModel<FragmentSettingsViewModel> {
        FragmentSettingsViewModel(
            settingsProvider = get()
        )
    }
}
