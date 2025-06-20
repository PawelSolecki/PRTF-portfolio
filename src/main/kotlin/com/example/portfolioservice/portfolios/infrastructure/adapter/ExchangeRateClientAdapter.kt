package com.example.portfolioservice.portfolios.infrastructure.adapter

import com.example.portfolioservice.portfolios.domain.port.outgoing.ExchangeRateProvider
import java.math.BigDecimal

class ExchangeRateClientAdapter(
    private val exchangeRateClient: ExchangeRateClient
) : ExchangeRateProvider{
    override fun getExchangeRate(fromCurrency: String): Map<String, BigDecimal> {
        return exchangeRateClient.getExchangeRates(fromCurrency.lowercase()).currencies[fromCurrency.lowercase()]
            ?: throw IllegalArgumentException("No exchange rates found for currency: $fromCurrency")
    }
}