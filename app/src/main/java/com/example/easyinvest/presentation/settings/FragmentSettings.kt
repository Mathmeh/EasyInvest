package com.example.easyinvest.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.easyinvest.databinding.FragmentSettingsBinding
import com.example.easyinvest.presentation.BaseFragment
import com.example.easyinvest.presentation.settings.BottomSheet.CurrencyBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSettings : BaseFragment<FragmentSettingsBinding>() {

    private val fragmentSettingsViewModel: FragmentSettingsViewModel by activityViewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSettingsViewModel.currencySettings
            .observe(viewLifecycleOwner) { currentCurrency ->
                binding.defaultCurrencySetButton.text = currentCurrency
            }

        with(binding.defaultCurrencySetButton) {
            setOnClickListener {
                showCurrencyBottomSheet()
            }
        }
    }

    private fun showCurrencyBottomSheet() {
        val bottomSheet = CurrencyBottomSheet()
        bottomSheet.show(
            parentFragmentManager, bottomSheet.tag
        )
    }
}
