package com.example.easyinvest.presentation.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easyinvest.databinding.FragmentPortfolioBinding
import com.example.easyinvest.presentation.BaseFragment
import com.example.easyinvest.presentation.portfolio.rv.PortfolioAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentPortfolio : BaseFragment<FragmentPortfolioBinding>() {

    private val fragmentPortfolioViewModel: FragmentPortfolioViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val portfolioAdapter = PortfolioAdapter()

        binding.recyclerviewPortfolio.apply {
            adapter = portfolioAdapter
            layoutManager = LinearLayoutManager(context)
        }

        fragmentPortfolioViewModel.portfolioList.observe(viewLifecycleOwner) { portfolio ->
            portfolioAdapter.submitList(portfolio)
        }
    }
}
