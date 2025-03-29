package com.example.portfolioservice.portfolios.domain.model

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.PortfolioEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Portfolio(
    val id: UUID? = null,
    val ownerId: UUID? = null,
    val name: String = "",
    val assets: MutableList<Asset> = mutableListOf(),
    val allocations: MutableList<PortfolioAllocation> = mutableListOf(),
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val totalValue: BigDecimal = BigDecimal.ZERO

){
    fun toEntity(): PortfolioEntity {
        return PortfolioEntity(
            id = id,
            ownerId = ownerId,
            name = name,
            assets = assets.map { it.toEntity() }.toMutableList(),
            allocations = allocations.map { it.toEntity() }.toMutableList(),
            createdAt = createdAt,
            updatedAt = updatedAt,
            totalValue = totalValue
        )
    }
}
