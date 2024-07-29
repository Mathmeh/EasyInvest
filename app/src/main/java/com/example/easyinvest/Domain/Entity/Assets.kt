package com.example.easyinvest.Domain.Entity

import java.time.LocalDate

open class Asset(
    open val id: Int,
    open val name: String,
    open val purchasePrice: Double,
    open val meta: AssetMeta,
    open val currency: Currency,
    open val ticker: String
) {
    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + purchasePrice.hashCode()
        result = 31 * result + meta.hashCode()
        result = 31 * result + currency.hashCode()
        result = 31 * result + ticker.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Asset) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (purchasePrice != other.purchasePrice) return false
        if (meta != other.meta) return false
        if (currency != other.currency) return false
        if (ticker != other.ticker) return false

        return true
    }
}

data class Cash(
    override val id: Int,
    override val name: String,
    override val purchasePrice: Double,
    override val meta: AssetMeta,
    override val currency: Currency,
    override val ticker: String
) : Asset(id, name, purchasePrice, meta, currency, ticker)

data class Bond(
    override val id: Int,
    override val name: String,
    override val purchasePrice: Double,
    override val meta: AssetMeta,
    override val currency: Currency,
    override val ticker: String,
    val purchaseDate: LocalDate,
    val paymentDate: LocalDate,
    val income: Double
) : Asset(id, name, purchasePrice, meta, currency, ticker)

data class Stock(
    override val id: Int,
    override val name: String,
    override val purchasePrice: Double,
    override val meta: AssetMeta,
    override val currency: Currency,
    override val ticker: String,
    val purchaseDate: LocalDate,
    val paymentDayNo: Int,
    val dividend: Double
) : Asset(id, name, purchasePrice, meta, currency, ticker)
