package com.example.easyinvest.presentation.asset.RV

import AssetDiffCallback
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.easyinvest.Domain.Entity.Asset
import com.example.easyinvest.databinding.ItemAssetBinding

class AssetAdapter : ListAdapter<Asset, AssetViewHolder>(AssetDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder(
            ItemAssetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
