package com.example.portfolioservice.portfolios.infrastructure.repository.entity

import com.example.portfolioservice.portfolios.domain.model.AssetType
import com.example.portfolioservice.portfolios.domain.model.PortfolioAllocation
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "portfolio_allocations")
class PortfolioAllocationEntity @JvmOverloads constructor(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    var portfolio: PortfolioEntity? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val assetType: AssetType? = null,

    @Column(nullable = false, precision = 5, scale = 2)
    val percentage: BigDecimal = BigDecimal.ZERO
) {
    fun toDomain(): PortfolioAllocation {
        return PortfolioAllocation(
            id = id!!,
            portfolioId = portfolio?.id!!,
            assetType = assetType,
            percentage = percentage
        )
    }
}