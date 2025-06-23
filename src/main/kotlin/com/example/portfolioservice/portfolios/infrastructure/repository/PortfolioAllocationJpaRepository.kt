package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.PortfolioAllocationEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PortfolioAllocationJpaRepository : JpaRepository<PortfolioAllocationEntity, UUID> {
    fun findByPortfolioId(portfolioId: UUID): PortfolioAllocationEntity

    fun deleteByPortfolioId(portfolioId: UUID)
}