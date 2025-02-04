package com.example.portfolioservice.portfolios.application.dto.transaction

import com.example.portfolioservice.portfolios.domain.model.TransactionType
import java.math.BigDecimal

data class PatchTransactionDTO(
    val type: TransactionType,
    val quantity: BigDecimal,
    val pricePerUnit: BigDecimal,
)
