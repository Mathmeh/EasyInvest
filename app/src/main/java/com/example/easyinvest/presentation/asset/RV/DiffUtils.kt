package com.example.easyinvest.presentation.asset.RV

import androidx.recyclerview.widget.DiffUtil
import com.example.easyinvest.Domain.Entity.Asset

class DiffUtils(
    val oldList: List<Asset>,
    val newList: List<Asset>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
