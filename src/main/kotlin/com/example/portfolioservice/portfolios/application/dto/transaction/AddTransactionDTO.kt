package com.example.portfolioservice.portfolios.application.dto.transaction

import com.example.portfolioservice.portfolios.domain.model.Transaction
import com.example.portfolioservice.portfolios.domain.model.TransactionType
import java.math.BigDecimal
import java.util.*

data class AddTransactionDTO(
    val assetId: UUID,
    val type: TransactionType,
    val quantity: BigDecimal,
    val pricePerUnit: BigDecimal,
){
    fun toDomain(): Transaction {
        return Transaction(
            assetId = assetId,
            type = type,
            quantity = quantity,
            pricePerUnit = pricePerUnit
        )
    }
}
