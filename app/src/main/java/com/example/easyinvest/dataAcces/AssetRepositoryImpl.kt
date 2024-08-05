package com.example.easyinvest.dataAcces

import com.example.easyinvest.dataAcces.mock.MockAssetsList
import com.example.easyinvest.domain.AssetsRepository
import com.example.easyinvest.domain.entity.Asset
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetRepositoryImpl
@Inject constructor() : AssetsRepository {
    override suspend fun getAllAssets(): List<Asset> {
        // TODO("This should be replaced with DB request")
        return MockAssetsList.getAssetList()
    }

    override suspend fun getAssetById(id: Int): Asset {
        // TODO("This should be replaced with DB request")
        return MockAssetsList.getAssetById(id)
    }
}
