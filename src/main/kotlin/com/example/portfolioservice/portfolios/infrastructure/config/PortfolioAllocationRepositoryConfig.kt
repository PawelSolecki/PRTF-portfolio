package com.example.portfolioservice.portfolios.infrastructure.config

import com.example.portfolioservice.portfolios.infrastructure.repository.PortfolioAllocationJpaRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.PortfolioAllocationJpaRepositoryAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PortfolioAllocationRepositoryConfig {

    @Bean
    fun portfolioAllocationRepository(
        portfolioAllocationJpaRepository: PortfolioAllocationJpaRepository
    ) : PortfolioAllocationJpaRepositoryAdapter {
        return PortfolioAllocationJpaRepositoryAdapter(portfolioAllocationJpaRepository)
    }
}