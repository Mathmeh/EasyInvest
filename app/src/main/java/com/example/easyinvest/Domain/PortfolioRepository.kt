package com.example.easyinvest.domain

import com.example.easyinvest.domain.entity.Portfolio

interface PortfolioRepository {
    suspend fun getListPortfolio(): List<Portfolio>
}
