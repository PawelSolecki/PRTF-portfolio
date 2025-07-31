package com.example.portfolioservice.portfolios.domain.model

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.AssetEntity
import com.example.portfolioservice.portfolios.infrastructure.repository.entity.TransactionEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Transaction(
    val id: UUID? = null,
    val assetId: UUID,
    val type: TransactionType?,
    val quantity: BigDecimal,
    val pricePerUnit: BigDecimal,
    val date: LocalDateTime

){
    fun toEntity(): TransactionEntity {
        return TransactionEntity(
            id = id,
            asset = AssetEntity(id = assetId),
            type = type,
            quantity = quantity,
            pricePerUnit = pricePerUnit,
            date = date
        )
    }
}
