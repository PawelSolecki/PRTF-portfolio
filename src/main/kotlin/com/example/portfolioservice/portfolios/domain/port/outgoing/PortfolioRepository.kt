package com.example.portfolioservice.portfolios.domain.port.outgoing

import com.example.portfolioservice.portfolios.domain.model.Portfolio
import java.util.*

interface PortfolioRepository {
    fun save(portfolio: Portfolio)

    fun getPortfolioById(id: UUID): Portfolio

    fun getPortfoliosByOwnerId(ownerId: UUID): List<Portfolio>

    fun update(portfolio: Portfolio)

    fun delete(id: UUID)

}