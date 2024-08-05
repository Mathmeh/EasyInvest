package com.example.easyinvest.presentation.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easyinvest.domain.PortfolioRepository
import com.example.easyinvest.domain.entity.Portfolio
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class FragmentPortfolioViewModel
@Inject constructor(private val portfolioProvider: PortfolioRepository) : ViewModel() {
    private val _portfolio = MutableLiveData<List<Portfolio>>()
    val portfolioList: LiveData<List<Portfolio>> get() = _portfolio

    init {
        loadPortfolio()
    }

    fun loadPortfolio() {
        viewModelScope.launch {
            _portfolio.value = portfolioProvider.getListPortfolio()
        }
    }
}
