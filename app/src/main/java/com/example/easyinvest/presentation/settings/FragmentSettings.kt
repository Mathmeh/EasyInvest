package com.example.easyinvest.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.easyinvest.Domain.Entity.Currency
import com.example.easyinvest.R
import com.example.easyinvest.databinding.FragmentSettingsBinding
import com.example.easyinvest.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSettings : BaseFragment<FragmentSettingsBinding>() {

    private val fragmentSettingsViewModel by viewModels<FragmentSettingsViewModel>()

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

        val spinner = binding.spinner

        val currencies = Currency.getCurrNames()
        val adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, currencies
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        fragmentSettingsViewModel.getCurrencySettings.observe(viewLifecycleOwner) { currentCur ->
            binding.spinner.setSelection(Currency.getCurrIndex(currentCur))
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = currencies[position]
                fragmentSettingsViewModel.setCurrencySettings(selectedItem)
                Toast.makeText(
                    requireContext(), getString(R.string.def_curr, selectedItem), Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        return binding.root
    }
}
