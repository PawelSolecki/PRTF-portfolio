package com.example.portfolioservice.portfolios.infrastructure.adapter

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "exchange-rate-client",
    url = "https://latest.currency-api.pages.dev/v1/currencies",
)
interface ExchangeRateClient {
    @GetMapping("/{from}.json")
    fun getExchangeRates(@PathVariable from: String): RawExchangeRateResponse
}

