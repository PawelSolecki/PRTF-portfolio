package com.example.portfolioservice.portfolios.application.dto.portfolio

import java.math.BigDecimal

class GetPortfolioSummaryDTO(
    val totalValue: BigDecimal,
    val totalCost: BigDecimal
)