package com.example.portfolioservice.portfolios.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Transaction(
    val id: UUID,
    val assetID: UUID,
    val type: TransactionType,
    val quantity: BigDecimal,
    val pricePerUnit: BigDecimal,
    val date: LocalDateTime

)
