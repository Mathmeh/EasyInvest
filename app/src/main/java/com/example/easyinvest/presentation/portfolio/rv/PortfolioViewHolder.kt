package com.example.easyinvest.presentation.portfolio.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.easyinvest.databinding.ItemPortfolioBinding
import com.example.easyinvest.domain.entity.Portfolio

class PortfolioViewHolder(private val binding: ItemPortfolioBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Portfolio) {
        with(binding) {
            portfolioName.text = item.name
        }
    }
}
