package com.example.easyinvest.presentation.portfolio.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.easyinvest.Domain.Entity.Portfolio
import com.example.easyinvest.databinding.ItemPortfolioBinding

class PortfolioAdapter : ListAdapter<Portfolio, PortfolioViewHolder>(PortfolioDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val binding =
            ItemPortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PortfolioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
