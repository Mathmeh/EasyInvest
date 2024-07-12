package com.example.easyinvest.presentation.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.easyinvest.databinding.FragmentPortfolioBinding
import com.example.easyinvest.presentation.BaseFragment

class FragmentPortfolio : BaseFragment<FragmentPortfolioBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioBinding.inflate(inflater, container, false)
}