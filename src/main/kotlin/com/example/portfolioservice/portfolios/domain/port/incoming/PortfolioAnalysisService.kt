package com.example.portfolioservice.portfolios.domain.port.incoming

import com.example.portfolioservice.portfolios.application.dto.portfolio.GetPortfolioRebalancing
import java.math.BigDecimal
import java.util.*

interface PortfolioAnalysisService {
    fun calculateRebalancing(portfolioId: UUID, additionalInvestment: BigDecimal): GetPortfolioRebalancing
}