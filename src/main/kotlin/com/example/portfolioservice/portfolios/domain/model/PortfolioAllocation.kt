package com.example.portfolioservice.portfolios.domain.model

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.PortfolioAllocationEntity
import com.example.portfolioservice.portfolios.infrastructure.repository.entity.PortfolioEntity
import java.math.BigDecimal
import java.util.*

class PortfolioAllocation(
    val id: UUID? = null,
    var portfolioId: UUID? = null,
    val assetType: AssetType? = null,
    val percentage: BigDecimal = BigDecimal.ZERO
) {
    fun toEntity(): PortfolioAllocationEntity {
        return PortfolioAllocationEntity(
            id = id,
            portfolio = PortfolioEntity(id = portfolioId),
            assetType = assetType,
            percentage = percentage
        )
    }
}