package com.example.portfolioservice.portfolios.domain.port.outgoing

import java.math.BigDecimal

interface ExchangeRateProvider {
    fun getExchangeRate(fromCurrency: String): Map<String,BigDecimal>
}