package com.example.portfolioservice.portfolios.application.service

import com.example.portfolioservice.portfolios.application.dto.portfolio.GetPortfolioRebalancing
import com.example.portfolioservice.portfolios.domain.model.AssetType
import com.example.portfolioservice.portfolios.domain.port.incoming.PortfolioAnalysisService
import com.example.portfolioservice.portfolios.domain.port.outgoing.AssetRepository
import com.example.portfolioservice.portfolios.domain.port.outgoing.PortfolioRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class PortfolioAnalysisServiceImpl(
    val portfolioRepository: PortfolioRepository,
    val assetRepository: AssetRepository
) : PortfolioAnalysisService {
    override fun calculateRebalancing(portfolioId: UUID, additionalInvestment: BigDecimal): GetPortfolioRebalancing {
        val portfolio = portfolioRepository.getPortfolioById(portfolioId)
        val newTotalValue = portfolio.totalValue.values.sumOf { it } + additionalInvestment
        val currentAssetsValues = assetRepository.calculateAssetsValues(portfolioId)

        val categoryDeficit = portfolio.allocations
            .filter { it.assetType != null }
            .associate { allocation ->
                val assetType = allocation.assetType!!
                val targetValue = allocation.percentage.divide(BigDecimal(100)).multiply(newTotalValue)
                val currentValue = currentAssetsValues[assetType] ?: BigDecimal.ZERO

                val deficit = targetValue.subtract(currentValue).let {
                    if (it < BigDecimal.ZERO) BigDecimal.ZERO else it
                }

                assetType to deficit
            }

        val totalDeficit = categoryDeficit.values.sumOf { it.toDouble() }.toBigDecimal()
        val allocationMap = mutableMapOf<AssetType, BigDecimal>()

        if (totalDeficit <= additionalInvestment) {
            categoryDeficit.forEach { (type, deficit) ->
                allocationMap[type] = deficit
            }
            val remaining = additionalInvestment.subtract(totalDeficit)
            if (remaining > BigDecimal.ZERO) {
                portfolio.allocations.forEach { allocation ->
                    val add = remaining.multiply(allocation.percentage)
                    allocationMap.merge(allocation.assetType!!, add, BigDecimal::add)
                }
            }
        } else {
            categoryDeficit.forEach { (type, deficit) ->
                val ratio = if (totalDeficit == BigDecimal.ZERO) BigDecimal.ZERO
                else deficit.divide(totalDeficit, 10, BigDecimal.ROUND_HALF_EVEN)

                allocationMap[type] = additionalInvestment.multiply(ratio)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN)
            }
        }

        return GetPortfolioRebalancing(allocationMap.filterValues { it > BigDecimal.ZERO })
    }

}