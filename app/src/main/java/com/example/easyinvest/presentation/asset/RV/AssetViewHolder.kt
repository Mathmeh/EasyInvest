package com.example.easyinvest.presentation.asset.RV

import androidx.recyclerview.widget.RecyclerView
import com.example.easyinvest.Domain.Entity.Asset
import com.example.easyinvest.Domain.Entity.Bond
import com.example.easyinvest.Domain.Entity.Cash
import com.example.easyinvest.Domain.Entity.Stock
import com.example.easyinvest.R
import com.example.easyinvest.databinding.ItemAssetBinding

class AssetViewHolder(var binding: ItemAssetBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(asset: Asset) {
        binding.apply {
            nameTextView.text = asset.name
            textViewTicker.text = asset.ticker
            textViewPurchasePrice.text = asset.purchasePrice.toString()
        }
        if (asset is Cash) {
            binding.imageView.setImageResource(R.drawable.cash)
        }
        if (asset is Stock) {
            binding.imageView.setImageResource(R.drawable.stock)
        }
        if (asset is Bond) {
            binding.imageView.setImageResource(R.drawable.bond)
        }
    }
}
