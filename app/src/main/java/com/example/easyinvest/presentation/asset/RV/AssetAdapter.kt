package com.example.easyinvest.presentation.asset.RV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.easyinvest.Domain.Entity.Asset
import com.example.easyinvest.databinding.ItemAssetBinding

class AssetAdapter(private var assets: List<Asset>) :
    RecyclerView.Adapter<AssetViewHolder>(),
    Observer<List<Asset>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder(
            ItemAssetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    fun submit(newAssetList: List<Asset>) {
        val diffUtilCallback = DiffUtils(assets, newAssetList)
        assets = newAssetList
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        holder.bind(assets[position])
    }

    override fun getItemCount(): Int {
        return assets.size
    }

    override fun onChanged(value: List<Asset>) {
        this.assets = value
    }
}
