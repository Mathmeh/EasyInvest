package com.example.easyinvest.Domain.Entity

import java.time.LocalDate

open class Asset(
    open val id: Int,
    open val name: String,
    open val purchasePrice: Double,
    open val meta: AssetMeta,
    open val currency: Currency,
    open val ticker: String
)

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
