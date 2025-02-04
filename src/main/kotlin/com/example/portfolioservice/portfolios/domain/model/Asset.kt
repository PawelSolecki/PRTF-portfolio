package com.example.portfolioservice.portfolios.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Asset(
    val id: UUID,
    val portfolioId: UUID,
    val type: AssetType,
    val name: String,
    val totalQuantity: BigDecimal,
    val lastUpdated: LocalDateTime,
    val market: String?,
    val ticker: String?,
)