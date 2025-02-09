package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.domain.model.Portfolio
import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioRepository
import java.util.*

class PortfolioJpaRepositoryAdapter(
    private val portfolioJpaRepository: PortfolioJpaRepository,
) : PortfolioRepository{
    override fun save(portfolio: Portfolio) {
        portfolioJpaRepository.save(portfolio.toEntity())
    }

    override fun getPortfolioById(id: UUID): Portfolio {
        return portfolioJpaRepository.findById(id).get().toDomain()
    }

    override fun getPortfoliosByOwnerId(ownerId: UUID): List<Portfolio> {
        return portfolioJpaRepository.findByOwnerId(ownerId).map { it.toDomain() }
    }

    override fun update(portfolio: Portfolio) {
//        portfolioJpaRepository.save(mapper.toEntity(portfolio))
    }

    override fun delete(id: UUID) {
        portfolioJpaRepository.deleteById(id)
    }
}