package com.example.portfolioservice.portfolios.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Portfolio(
    val id: UUID,
    val ownerId: UUID,
    val name: String,
    val assets: List<Asset>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val totalValue: BigDecimal

)
