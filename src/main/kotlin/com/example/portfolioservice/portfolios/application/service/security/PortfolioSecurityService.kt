package com.example.portfolioservice.portfolios.application.service.security

import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service("portfolioSecurity")
class PortfolioSecurityService(
    private val portfolioRepository: PortfolioRepository
) {

    fun isOwner(portfolioId: UUID, userId: UUID): Boolean {
        val portfolio = portfolioRepository.getPortfolioById(portfolioId)
        return portfolio.ownerId == userId
    }
}