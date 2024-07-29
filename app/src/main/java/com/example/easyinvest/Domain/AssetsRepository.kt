package com.example.easyinvest.Domain

import com.example.easyinvest.Domain.Entity.Asset

interface AssetsRepository {
    fun getAllAssets(): List<Asset>
    fun getAssetById(id: Int): Asset
}
