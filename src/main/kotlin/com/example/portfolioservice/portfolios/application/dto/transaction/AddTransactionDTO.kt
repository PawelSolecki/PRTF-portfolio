package com.example.portfolioservice.portfolios.application.dto.transaction

import com.example.portfolioservice.portfolios.domain.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class AddTransactionDTO(
    val assetID: UUID,
    val type: TransactionType,
    val quantity: BigDecimal,
    val pricePerUnit: BigDecimal,
)
