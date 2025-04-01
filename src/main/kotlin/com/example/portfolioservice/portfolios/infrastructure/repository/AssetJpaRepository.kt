package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.AssetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.math.BigDecimal
import java.util.*

interface AssetJpaRepository : JpaRepository<AssetEntity, UUID> {
    fun findByPortfolioId(portfolioId: UUID): List<AssetEntity>

    @Query(
    """
    SELECT a.type, SUM(a.price_per_unit * a.total_quantity) 
    FROM assets a 
    WHERE a.portfolio_id = :portfolioId 
    GROUP BY a.type
    """,
    nativeQuery = true
    )
    fun calculateAssetsValues(portfolioId: UUID): Map<String, BigDecimal>
}