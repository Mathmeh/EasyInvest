package com.example.easyinvest.dataAcces.mock

import com.example.easyinvest.domain.entity.Portfolio

object MockPortfolioList {
    private val portfolioList = listOf(
        Portfolio(0, "Портфель №1"),
        Portfolio(1, "Портфель №2"),
        Portfolio(2, "Портфель №3"),
        Portfolio(3, "Портфель №4"),
        Portfolio(4, "Портфель №5")
    ).associateBy { it.id }

    fun getListPortfolio(): List<Portfolio> {
        return portfolioList.values.toList()
    }
}
