package com.example.portfolioservice.portfolios.infrastructure.config

import com.example.portfolioservice.portfolios.infrastructure.repository.PortfolioJpaRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.PortfolioJpaRepositoryAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PortfolioRepositoryConfig {

    @Bean
    fun portfolioRepository(
        portfolioJpaRepository: PortfolioJpaRepository,

    ): PortfolioJpaRepositoryAdapter {
        return PortfolioJpaRepositoryAdapter(portfolioJpaRepository)
    }

}