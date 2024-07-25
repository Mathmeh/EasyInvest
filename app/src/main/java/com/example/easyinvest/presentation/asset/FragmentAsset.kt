package com.example.easyinvest.presentation.asset

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.easyinvest.databinding.FragmentAssetBinding
import com.example.easyinvest.presentation.BaseFragment

class FragmentAsset : BaseFragment<FragmentAssetBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAssetBinding.inflate(inflater, container, false)
}
