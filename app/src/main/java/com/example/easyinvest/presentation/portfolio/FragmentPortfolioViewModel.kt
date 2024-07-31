package com.example.easyinvest.presentation.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.Domain.Entity.Portfolio
import com.example.easyinvest.Domain.PortfolioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentPortfolioViewModel
@Inject constructor(private val portfolioProvider: PortfolioRepository) : ViewModel() {
    private val _portfolio = MutableLiveData<List<Portfolio>>().apply {
        value = portfolioProvider.getListPortfolio()
    }
    val portfolioList: LiveData<List<Portfolio>> get() = _portfolio
}
