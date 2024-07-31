package com.example.easyinvest.Domain

import com.example.easyinvest.Domain.Entity.Portfolio

interface PortfolioRepository {
    fun getListPortfolio(): List<Portfolio>
}
