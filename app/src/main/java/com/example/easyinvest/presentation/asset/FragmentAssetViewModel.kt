package com.example.easyinvest.presentation.asset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.Domain.AssetsRepository
import com.example.easyinvest.Domain.Entity.Asset
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentAssetViewModel
@Inject constructor(private val assetProvider: AssetsRepository) : ViewModel() {
    private val _assets = MutableLiveData<List<Asset>>().apply {
        value = assetProvider.getAllAssets()
    }
    val assetsList: LiveData<List<Asset>> get() = _assets

    fun getAssetById(id: Int): Asset {
        return assetProvider.getAssetById(id)
    }
}
