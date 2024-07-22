package com.example.easyinvest.presentation.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.easyinvest.databinding.FragmentSettingsBinding
import com.example.easyinvest.presentation.BaseFragment
import com.example.easyinvest.presentation.settings.BottomSheet.CurrencyBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSettings : BaseFragment<FragmentSettingsBinding>() {

    private lateinit var fragmentSettingsViewModel: FragmentSettingsViewModel

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        fragmentSettingsViewModel =
            ViewModelProvider(requireActivity())[FragmentSettingsViewModel::class.java]

        fragmentSettingsViewModel.getCurrencySettings
            .observe(viewLifecycleOwner) { currentCurrency ->
                binding.defaultCurrencySetButton.text = currentCurrency
            }

        with(binding.defaultCurrencySetButton) {
            setOnClickListener {
                showCurrencyBottomSheet()
                Log.i("d", 1.toString())
            }
        }

        return binding.root
    }

    private fun showCurrencyBottomSheet() {
        val bottomSheet = CurrencyBottomSheet()
        bottomSheet.show(
            parentFragmentManager, bottomSheet.tag
        )

        Log.i("aaaa", fragmentSettingsViewModel.getCurrencySettings.value.toString())
    }
}
