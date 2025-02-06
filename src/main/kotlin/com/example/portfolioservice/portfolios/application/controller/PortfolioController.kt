package com.example.portfolioservice.portfolios.application.controller

import com.example.portfolioservice.portfolios.application.dto.portfolio.AddPortfolioDTO
import com.example.portfolioservice.portfolios.application.dto.portfolio.PatchPortfolioDTO
import com.example.portfolioservice.portfolios.domain.model.Portfolio
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/portfolio")
class PortfolioController(
    val portfolioService: PortfolioService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPortfolio(@RequestBody portfolio: AddPortfolioDTO) {
        portfolioService.createPortfolio(portfolio)
    }

    @GetMapping("/{id}")
    fun getPortfolioById(@PathVariable id: UUID): Portfolio {
        return portfolioService.getPortfolioById(id)
    }

    @GetMapping("/owner/{ownerId}")
    fun getPortfoliosByOwnerId(@PathVariable ownerId: UUID): List<Portfolio> {
        return portfolioService.getPortfoliosByOwnerId(ownerId)
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



}