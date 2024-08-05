package com.example.easyinvest.presentation.asset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easyinvest.domain.AssetsRepository
import com.example.easyinvest.domain.entity.Asset
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@HiltViewModel
class FragmentAssetViewModel
@Inject constructor(private val assetProvider: AssetsRepository) : ViewModel() {
    private val _assets = MutableLiveData<List<Asset>>()
    val assetsList: LiveData<List<Asset>> get() = _assets

    init {
        viewModelScope.launch {
            _assets.value = assetProvider.getAllAssets()
        }
    }

    suspend fun getAssetById(id: Int): Asset? {
        return viewModelScope.async {
            try {
                assetProvider.getAssetById(id)
            } catch (e: IllegalArgumentException) {
                null
            }
        }.await()
    }
}
