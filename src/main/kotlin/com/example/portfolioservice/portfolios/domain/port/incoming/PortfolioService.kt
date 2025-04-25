package com.example.portfolioservice.portfolios.domain.port.incoming

import com.example.portfolioservice.portfolios.application.dto.portfolio.AddPortfolioDTO
import com.example.portfolioservice.portfolios.application.dto.portfolio.PatchPortfolioDTO
import com.example.portfolioservice.portfolios.domain.model.Portfolio
import java.util.*

interface PortfolioService {

    fun createPortfolio(userId: UUID, portfolio: AddPortfolioDTO)

    fun getPortfolioById(id: UUID): Portfolio

    fun getPortfoliosByOwnerId(ownerId: UUID): List<Portfolio>

    fun updatePortfolio(portfolio: PatchPortfolioDTO)

    fun deletePortfolio(id: UUID)
}