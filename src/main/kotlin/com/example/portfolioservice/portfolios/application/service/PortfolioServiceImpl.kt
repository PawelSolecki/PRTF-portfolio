package com.example.portfolioservice.portfolios.application.service

import com.example.portfolioservice.portfolios.application.dto.portfolio.AddPortfolioDTO
import com.example.portfolioservice.portfolios.application.dto.portfolio.PatchPortfolioDTO
import com.example.portfolioservice.portfolios.application.mapper.PortfolioMapper
import com.example.portfolioservice.portfolios.domain.model.Portfolio
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioService
import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PortfolioServiceImpl(
    val portfolioRepository: PortfolioRepository,
    val portfolioMapper: PortfolioMapper
): PortfolioService {

    override fun createPortfolio(portfolio: AddPortfolioDTO) {
        val portfolioDomain = portfolioMapper.toDomain(portfolio).copy(ownerId = UUID.randomUUID())
        portfolioRepository.save(portfolioDomain)
    }

    override fun getPortfolioById(id: UUID): Portfolio {
        return portfolioRepository.getPortfolioById(id)
    }

    override fun getPortfoliosByOwnerId(ownerId: UUID): List<Portfolio> {
        return portfolioRepository.getPortfoliosByOwnerId(ownerId)
    }

    override fun updatePortfolio(portfolio: PatchPortfolioDTO) {
        portfolioRepository.update(portfolioMapper.toDomain(portfolio))
    }

    override fun deletePortfolio(id: UUID) {
        portfolioRepository.delete(id)
    }
}