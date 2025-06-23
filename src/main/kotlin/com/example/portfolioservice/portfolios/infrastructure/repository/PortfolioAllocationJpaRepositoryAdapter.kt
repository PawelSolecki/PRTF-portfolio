package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.domain.model.PortfolioAllocation
import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioAllocationRepository
import java.util.*

class PortfolioAllocationJpaRepositoryAdapter(
    private val allocationJpaRepository: PortfolioAllocationJpaRepository
) : PortfolioAllocationRepository {
    override fun save(allocation: PortfolioAllocation) {
        allocationJpaRepository.save(allocation.toEntity())
    }

    override fun getAllocationById(id: UUID): PortfolioAllocation {
        return allocationJpaRepository.findById(id).get().toDomain()
    }

    override fun getAllocationsByPortfolioId(portfolioId: UUID): PortfolioAllocation {
        TODO("Not yet implemented")
    }

    override fun update(allocation: PortfolioAllocation) {
        allocationJpaRepository.save(allocation.toEntity())
    }

    override fun deleteAllocation(id: UUID) {
        allocationJpaRepository.deleteByPortfolioId(id)
    }

}