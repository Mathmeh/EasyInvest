package com.example.easyinvest.Domain.Entity

enum class Currency(val currencyName: String) {
    USD("usd"), EUR("eur"), CNY("cny"), RUB("rub"), BYN("byn");

    companion object {
        private const val USD_INDEX = 0
        private const val EUR_INDEX = 1
        private const val CNY_INDEX = 2
        private const val RUB_INDEX = 3
        private const val BYN_INDEX = 4

        public fun getCurrIndex(curr: String): Int {
            return when (curr) {
                "USD" -> USD_INDEX
                "EUR" -> EUR_INDEX
                "CNY" -> CNY_INDEX
                "RUB" -> RUB_INDEX
                "BYN" -> BYN_INDEX
                else -> -1
            }
        }

        fun getCurrNames(): List<String> {
            return entries.map { it.name }
        }
    }
}
