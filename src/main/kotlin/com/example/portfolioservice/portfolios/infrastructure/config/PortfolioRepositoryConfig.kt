package com.example.portfolioservice.portfolios.infrastructure.config

import com.example.portfolioservice.portfolios.infrastructure.repository.PortfolioJpaRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.PortfolioJpaRepositoryAdapter
import com.example.portfolioservice.portfolios.infrastructure.repository.mapper.EntitiesMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PortfolioRepositoryConfig {

    @Bean
    fun portfolioRepository(
        portfolioJpaRepository: PortfolioJpaRepository,
        mapper: EntitiesMapper

    ): PortfolioJpaRepositoryAdapter {
        return PortfolioJpaRepositoryAdapter(portfolioJpaRepository, mapper)
    }

}