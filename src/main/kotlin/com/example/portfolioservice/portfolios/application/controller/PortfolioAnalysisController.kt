package com.example.portfolioservice.portfolios.application.controller

import com.example.portfolioservice.portfolios.application.dto.portfolio.GetPortfolioRebalancing
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioAnalysisService
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/api/v1/analysis")
class PortfolioAnalysisController(
    val portfolioAnalysisService: PortfolioAnalysisService
) {

    @GetMapping("/rebalance/{portfolioId}")
    fun rebalancePortfolio(
        @PathVariable portfolioId: UUID,
        @RequestParam additionalInvestment: BigDecimal
    ): GetPortfolioRebalancing {
        return portfolioAnalysisService.calculateRebalancing(portfolioId, additionalInvestment)
    }
}