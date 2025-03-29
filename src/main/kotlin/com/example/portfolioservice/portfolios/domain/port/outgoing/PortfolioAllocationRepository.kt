package com.example.portfolioservice.portfolios.domain.port.outgoing

import com.example.portfolioservice.portfolios.domain.model.PortfolioAllocation
import java.util.*

interface PortfolioAllocationRepository {
    fun save(allocation: PortfolioAllocation)

    fun getAllocationById(id: UUID): PortfolioAllocation
    fun getAllocationsByPortfolioId(portfolioId: UUID): PortfolioAllocation

    fun update(allocation: PortfolioAllocation)

    fun deleteAllocation(id: UUID)

}