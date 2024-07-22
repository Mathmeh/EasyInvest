package com.example.easyinvest.presentation.settings.BottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.easyinvest.Domain.Entity.Currency
import com.example.easyinvest.R
import com.example.easyinvest.presentation.settings.FragmentSettingsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyBottomSheet : BottomSheetDialogFragment() {

    private lateinit var currencies: List<String>
    private lateinit var settingsViewModel: FragmentSettingsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_currency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingsViewModel =
            ViewModelProvider(requireActivity())[FragmentSettingsViewModel::class.java]

        currencies = Currency.getCurrNames()
        val listView: ListView = view.findViewById(R.id.listView)

        val adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1, currencies
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = currencies[position]
            settingsViewModel.setCurrencySettings(selectedItem)
            Toast.makeText(
                requireContext(),
                getString(R.string.def_curr, selectedItem),
                Toast.LENGTH_SHORT
            ).show()
            dismiss()
        }
    }
}
