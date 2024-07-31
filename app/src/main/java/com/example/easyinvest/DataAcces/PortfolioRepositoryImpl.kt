package com.example.easyinvest.DataAcces

import com.example.easyinvest.DataAcces.Mock.MockPortfolioList
import com.example.easyinvest.Domain.Entity.Portfolio
import com.example.easyinvest.Domain.PortfolioRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioRepositoryImpl
@Inject constructor() : PortfolioRepository {
    override fun getListPortfolio(): List<Portfolio> {
        return MockPortfolioList.getListPortfolio()
    }
}
