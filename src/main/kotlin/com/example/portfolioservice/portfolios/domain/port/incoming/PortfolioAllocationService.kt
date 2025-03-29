package com.example.portfolioservice.portfolios.domain.port.incoming

import com.example.portfolioservice.portfolios.application.dto.allocation.AddPortfolioAllocationDTO
import com.example.portfolioservice.portfolios.application.dto.allocation.PutPortfolioAllocationDTO
import com.example.portfolioservice.portfolios.domain.model.PortfolioAllocation
import java.util.*

interface PortfolioAllocationService {
    fun createAllocation(portfolioId: UUID, allocations: AddPortfolioAllocationDTO)
    fun getAllocationsByPortfolioId(portfolioId: UUID): PortfolioAllocation
    fun updateAllocation(portfolioId: UUID, allocations: PutPortfolioAllocationDTO)
}