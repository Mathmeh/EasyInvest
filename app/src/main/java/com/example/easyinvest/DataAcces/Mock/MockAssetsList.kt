package com.example.easyinvest.DataAcces.Mock

import com.example.easyinvest.Domain.Entity.Asset
import com.example.easyinvest.Domain.Entity.AssetMeta
import com.example.easyinvest.Domain.Entity.Bond
import com.example.easyinvest.Domain.Entity.Cash
import com.example.easyinvest.Domain.Entity.Currency
import com.example.easyinvest.Domain.Entity.Stock
import java.time.LocalDate

object MockAssetsList {
    private val assetsList = listOf(
        Cash(
            0,
            "USD Asset",
            1.0,
            AssetMeta(
                "USA",
                "cash"
            ),
            Currency.USD,
            "USD"
        ),
        Cash(
            1,
            "BYN Asset",
            2.3,
            AssetMeta(
                "BEL",
                "cash"
            ),
            Currency.BYN,
            "BYN"
        ),
        Stock(
            1,
            "Apple stock asset",
            200.0,
            AssetMeta("USA", "IT"),
            Currency.USD,
            "apple",
            LocalDate.of(2024, 3, 26),
            15,
            5.0
        ),

        Stock(
            2,
            "Roha i kopita stock asset",
            10.0,
            AssetMeta("BY", "AgroProm"),
            Currency.BYN,
            "RohIKop",
            LocalDate.of(2023, 2, 15),
            15,
            16.3
        ),
        Stock(
            3,
            "Aliexpress stock asset",
            150.0,
            AssetMeta("CHN", "Finance"),
            Currency.CNY,
            "ALI",
            LocalDate.of(2022, 1, 1),
            1,
            1.0
        ),
        Bond(
            4,
            "Moloko bond asset",
            20.0,
            AssetMeta("BY", "AgroProm"),
            Currency.BYN,
            "MOL",
            LocalDate.of(2024, 2, 4),
            LocalDate.of(2025, 2, 4),
            20.0
        ),
        Bond(
            5,
            "Ozimiye bond asset",
            10.0,
            AssetMeta("BY", "AgroProm"),
            Currency.BYN,
            "MOL",
            LocalDate.of(2022, 1, 1),
            LocalDate.of(2026, 1, 1),
            40.0
        )
    )

    fun getAssetList() = assetsList

    fun getAssetById(id: Int): Asset {
        return assetsList.find { it.id == id }
            ?: throw IllegalArgumentException("there is no asset with this id")
    }
}
