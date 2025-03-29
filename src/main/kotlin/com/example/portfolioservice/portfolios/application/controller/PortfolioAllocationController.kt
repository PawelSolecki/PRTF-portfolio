package com.example.portfolioservice.portfolios.application.controller

import com.example.portfolioservice.portfolios.application.dto.allocation.AddPortfolioAllocationDTO
import com.example.portfolioservice.portfolios.application.dto.allocation.PutPortfolioAllocationDTO
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioAllocationService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/portfolio-allocation")
class PortfolioAllocationController(
    val portfolioAllocationService: PortfolioAllocationService
) {

    @PostMapping("/{portfolioId}")
    @ResponseStatus(CREATED)
    fun createAllocation(@PathVariable portfolioId: UUID, @RequestBody allocation: AddPortfolioAllocationDTO) {
        portfolioAllocationService.createAllocation(portfolioId, allocation)
    }

    @GetMapping("/{portfolioId}")
    fun getAllocationsByPortfolioId(@PathVariable portfolioId: UUID) {
        portfolioAllocationService.getAllocationsByPortfolioId(portfolioId)
    }

    @PutMapping("/{portfolioId}")
    fun updateAllocation(@PathVariable portfolioId: UUID, @RequestBody allocation: PutPortfolioAllocationDTO) {
        portfolioAllocationService.updateAllocation(portfolioId, allocation)
    }

}