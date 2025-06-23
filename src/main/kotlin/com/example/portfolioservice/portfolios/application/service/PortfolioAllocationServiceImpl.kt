package com.example.portfolioservice.portfolios.application.service

import com.example.portfolioservice.portfolios.application.dto.allocation.AddPortfolioAllocationDTO
import com.example.portfolioservice.portfolios.application.dto.allocation.PutPortfolioAllocationDTO
import com.example.portfolioservice.portfolios.domain.model.PortfolioAllocation
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioAllocationService
import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioAllocationRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class PortfolioAllocationServiceImpl(
    val allocationRepository: PortfolioAllocationRepository
) : PortfolioAllocationService {
    @Transactional
    override fun createAllocation(portfolioId: UUID, dto: AddPortfolioAllocationDTO) {
        allocationRepository.deleteAllocation(portfolioId)
        dto.allocations.map {
            allocationRepository.save(it.toDomain(portfolioId))
        }
    }

    override fun getAllocationsByPortfolioId(portfolioId: UUID): PortfolioAllocation {
        return allocationRepository.getAllocationsByPortfolioId(portfolioId)
    }

    override fun updateAllocation(portfolioId: UUID, dto: PutPortfolioAllocationDTO) {
        allocationRepository.deleteAllocation(portfolioId)
        dto.allocations.map {
            allocationRepository.save(it.toDomain(portfolioId))
        }
    }
}