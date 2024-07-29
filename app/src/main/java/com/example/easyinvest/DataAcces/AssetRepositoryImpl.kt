package com.example.easyinvest.DataAcces

import com.example.easyinvest.DataAcces.Mock.MockAssetsList
import com.example.easyinvest.Domain.AssetsRepository
import com.example.easyinvest.Domain.Entity.Asset
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetRepositoryImpl
@Inject constructor() : AssetsRepository {
    override fun getAllAssets(): List<Asset> {
        // TODO("This should be replaced with DB request")
        return MockAssetsList.getAssetList()
    }

    override fun getAssetById(id: Int): Asset {
        // TODO("This should be replaced with DB request")
        return MockAssetsList.getAssetById(id)
    }
}
