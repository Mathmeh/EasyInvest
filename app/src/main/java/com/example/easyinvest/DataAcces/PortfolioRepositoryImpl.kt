package com.example.easyinvest.dataAcces

import com.example.easyinvest.dataAcces.mock.MockPortfolioList
import com.example.easyinvest.domain.PortfolioRepository
import com.example.easyinvest.domain.entity.Portfolio
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioRepositoryImpl
@Inject constructor() : PortfolioRepository {
    override suspend fun getListPortfolio(): List<Portfolio> {
        return MockPortfolioList.getListPortfolio()
    }
}
