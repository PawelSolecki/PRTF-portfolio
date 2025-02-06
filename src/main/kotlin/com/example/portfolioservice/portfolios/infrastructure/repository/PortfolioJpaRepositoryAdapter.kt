package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.domain.model.Portfolio
import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.mapper.EntitiesMapper
import java.util.*

class PortfolioJpaRepositoryAdapter(
    private val portfolioJpaRepository: PortfolioJpaRepository,
    private val mapper: EntitiesMapper
) : PortfolioRepository{
    override fun save(portfolio: Portfolio) {
        portfolioJpaRepository.save(mapper.toEntity(portfolio))
    }

    override fun getPortfolioById(id: UUID): Portfolio {
        return mapper.toDomain(portfolioJpaRepository.findById(id).get())
    }

    override fun getPortfoliosByOwnerId(ownerId: UUID): List<Portfolio> {
        return portfolioJpaRepository.findAll().map { mapper.toDomain(it) }
    }

    override fun update(portfolio: Portfolio) {
        portfolioJpaRepository.save(mapper.toEntity(portfolio))
    }

    override fun delete(id: UUID) {
        portfolioJpaRepository.deleteById(id)
    }
}