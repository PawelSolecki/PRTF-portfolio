package com.example.portfolioservice.portfolios.infrastructure.config

import com.example.portfolioservice.portfolios.infrastructure.repository.TransactionJpaRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.TransactionJpaRepositoryAdapter
import com.example.portfolioservice.portfolios.infrastructure.repository.mapper.EntitiesMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TransactionRepositoryConfig {

    @Bean
    fun transactionRepository(
        transactionJpaRepository: TransactionJpaRepository,
        mapper: EntitiesMapper

    ): TransactionJpaRepositoryAdapter {
        return TransactionJpaRepositoryAdapter(transactionJpaRepository, mapper)
    }

}