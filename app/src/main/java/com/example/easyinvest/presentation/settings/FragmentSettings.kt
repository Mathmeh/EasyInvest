package com.example.easyinvest.presentation.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.easyinvest.databinding.FragmentSettingsBinding
import com.example.easyinvest.presentation.BaseFragment

class FragmentSettings : BaseFragment<FragmentSettingsBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(inflater, container, false)
}