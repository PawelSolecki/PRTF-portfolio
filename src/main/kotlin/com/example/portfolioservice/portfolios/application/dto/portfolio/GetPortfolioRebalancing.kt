package com.example.portfolioservice.portfolios.application.dto.portfolio

import com.example.portfolioservice.portfolios.domain.model.AssetType
import java.math.BigDecimal

class GetPortfolioRebalancing(
    val balancedInvestment: Map<AssetType, BigDecimal>
)