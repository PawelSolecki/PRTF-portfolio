package com.example.portfolioservice.portfolios.application.service

import com.example.portfolioservice.portfolios.application.dto.portfolio.AddPortfolioDTO
import com.example.portfolioservice.portfolios.application.dto.portfolio.PatchPortfolioDTO
import com.example.portfolioservice.portfolios.domain.model.Currency
import com.example.portfolioservice.portfolios.domain.model.Portfolio
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioService
import com.example.portfolioservice.portfolios.domain.port.outgoing.ExchangeRateProvider
import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class PortfolioServiceImpl(
    val portfolioRepository: PortfolioRepository,
    val exchangeRateProvider: ExchangeRateProvider
) : PortfolioService {

    override fun createPortfolio(userId: UUID, portfolio: AddPortfolioDTO) {
        portfolioRepository.save(portfolio.toDomain(userId))
    }

    override fun getPortfolioById(id: UUID): Portfolio {
        return portfolioRepository.getPortfolioById(id)
    }

    override fun getPortfoliosByOwnerId(ownerId: UUID): List<Portfolio> {
        return portfolioRepository.getPortfoliosByOwnerId(ownerId)
    }

    override fun updatePortfolio(portfolio: PatchPortfolioDTO) {
        TODO("Not yet implemented")
    }

    override fun deletePortfolio(id: UUID) {
        portfolioRepository.delete(id)
    }

    override fun getPortfolioTotalValueInOneCurrency(id: UUID, currency: Currency): BigDecimal {
        val portfolio = portfolioRepository.getPortfolioById(id)
        val exchangeRates = exchangeRateProvider.getExchangeRate(currency.name)

        return portfolio.totalValue.entries.sumOf { (portfolioCurrency, value) ->
            val rate = exchangeRates[portfolioCurrency.name.lowercase()] ?: BigDecimal.ZERO
            value / rate
        }
    }

}
