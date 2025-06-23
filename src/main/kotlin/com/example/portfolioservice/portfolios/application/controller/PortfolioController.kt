package com.example.portfolioservice.portfolios.application.controller

import com.example.portfolioservice.portfolios.application.dto.portfolio.AddPortfolioDTO
import com.example.portfolioservice.portfolios.application.dto.portfolio.GetPortfolioSummaryDTO
import com.example.portfolioservice.portfolios.application.dto.portfolio.PatchPortfolioDTO
import com.example.portfolioservice.portfolios.domain.model.Currency
import com.example.portfolioservice.portfolios.domain.model.Portfolio
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.security.Principal
import java.util.*

@RestController
@RequestMapping("/api/v1/portfolio")
class PortfolioController(
    val portfolioService: PortfolioService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPortfolio(@RequestBody portfolio: AddPortfolioDTO, principal: Principal) {
        portfolioService.createPortfolio(UUID.fromString(principal.name), portfolio)
    }

    @GetMapping("/{id}")
    fun getPortfolioById(@PathVariable id: UUID): Portfolio {
        return portfolioService.getPortfolioById(id)
    }

    @GetMapping("/owner")
    fun getPortfoliosByOwnerId(principal: Principal): List<Portfolio> {
        return portfolioService.getPortfoliosByOwnerId(UUID.fromString(principal.name))
    }

    @PatchMapping
    fun updatePortfolio(@RequestBody portfolio: PatchPortfolioDTO) {
        portfolioService.updatePortfolio(portfolio)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePortfolio(@PathVariable id: UUID) {
        portfolioService.deletePortfolio(id)
    }

    @GetMapping("/{id}/total-value")
    fun getPortfolioTotalValue(@PathVariable id: UUID, @RequestParam currency: Currency): BigDecimal {
        return portfolioService.getPortfolioTotalValueInOneCurrency(id, currency)
    }

    @GetMapping("/{id}/summary")
    fun getPortfolioSummary(@PathVariable id: UUID, @RequestParam currency: Currency): GetPortfolioSummaryDTO{
        return portfolioService.getSummary(id, currency)
    }


}