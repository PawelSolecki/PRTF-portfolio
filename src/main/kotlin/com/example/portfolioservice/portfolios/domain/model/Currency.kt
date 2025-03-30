package com.example.portfolioservice.portfolios.domain.model

enum class Currency(val code: String) {
    USD("USD"),
    EUR("EUR"),
    PLN("PLN"),
    GBP("GBP");

    companion object {
        fun fromCode(code: String): Currency? = entries.find { it.code == code }
    }
}