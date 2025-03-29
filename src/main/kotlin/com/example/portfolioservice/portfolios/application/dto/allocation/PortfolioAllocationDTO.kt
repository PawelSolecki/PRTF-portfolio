package com.example.portfolioservice.portfolios.application.dto.allocation

import com.example.portfolioservice.portfolios.domain.model.AssetType
import com.example.portfolioservice.portfolios.domain.model.PortfolioAllocation
import java.math.BigDecimal
import java.util.*

class PortfolioAllocationDTO(
    val assetType: AssetType,
    val percentage: BigDecimal
) {
    fun toDomain(portfolioId: UUID): PortfolioAllocation {
        return PortfolioAllocation(
            portfolioId = portfolioId,
            assetType = assetType,
            percentage = percentage
        )
    }

}
