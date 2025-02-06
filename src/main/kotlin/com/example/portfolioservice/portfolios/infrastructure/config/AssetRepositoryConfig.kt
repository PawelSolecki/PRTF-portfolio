package com.example.portfolioservice.portfolios.infrastructure.config

import com.example.portfolioservice.portfolios.infrastructure.repository.AssetJpaRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.AssetJpaRepositoryAdapter
import com.example.portfolioservice.portfolios.infrastructure.repository.mapper.EntitiesMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AssetRepositoryConfig {
    
    @Bean
    fun assetRepository(
        assetJpaRepository: AssetJpaRepository,
        mapper: EntitiesMapper

    ): AssetJpaRepositoryAdapter {
        return AssetJpaRepositoryAdapter(assetJpaRepository, mapper)
    }
    
}