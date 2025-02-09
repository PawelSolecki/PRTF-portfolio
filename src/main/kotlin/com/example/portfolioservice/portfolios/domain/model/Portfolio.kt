package com.example.portfolioservice.portfolios.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Portfolio(
    val id: UUID? = null,
    val ownerId: UUID? = null,
    val name: String,
    val assets: List<Asset> = listOf(),
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val totalValue: BigDecimal = BigDecimal.ZERO

)
