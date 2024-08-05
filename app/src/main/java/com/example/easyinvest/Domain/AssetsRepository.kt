package com.example.easyinvest.domain

import com.example.easyinvest.domain.entity.Asset

interface AssetsRepository {
    suspend fun getAllAssets(): List<Asset>
    suspend fun getAssetById(id: Int): Asset
}
