package com.example.portfolioservice.portfolios.infrastructure.config

import com.example.portfolioservice.portfolios.infrastructure.adapter.ExchangeRateClient
import com.example.portfolioservice.portfolios.infrastructure.adapter.ExchangeRateClientAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExchangeRateClientConfig {

    @Bean
    fun exchangeRateClient(exchangeRateClient: ExchangeRateClient): ExchangeRateClientAdapter {
        return ExchangeRateClientAdapter( exchangeRateClient)
    }
}