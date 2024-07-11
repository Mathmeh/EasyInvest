package com.example.easyinvest.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.easyinvest.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentSettings : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val currencies = arrayOf("BYN", "USD", "EUR", "CNY", "RUB")
    private val fragmentSettingsViewModel = viewModel<FragmentSettingsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val spinner = binding.spinner
        val adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, currencies
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
        val selected = fragmentSettingsViewModel.value.getCurrencySettings
        val itemNumber = currencies.indexOf(selected.value ?: "USD")
        spinner.setSelection(itemNumber)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = currencies[position]
                fragmentSettingsViewModel.value.setCurrencySettings(selectedItem)
                Toast.makeText(
                    requireContext(), "Валюта по умолчанию: $selectedItem", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
