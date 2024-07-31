package com.example.easyinvest.Domain.Entity

import java.util.Objects

open class Portfolio(
    open val id: Int,
    open val name: String
) {
    override fun hashCode(): Int {
        return Objects.hash(id, name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Portfolio) return false

        return id == other.id && name == other.name
    }
}
