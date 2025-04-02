package com.example.portfolioservice.portfolios.domain.model

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.AssetEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Asset(
    val id: UUID,
    val portfolioId: UUID?,
    var type: AssetType?,
    var name: String,
    var broker: String,
    var currency: Currency = Currency.PLN,
    val totalQuantity: BigDecimal = BigDecimal.ZERO,
    var pricePerUnit: BigDecimal = BigDecimal.ZERO,
    val transactions: MutableList<Transaction> = mutableListOf(),
    val lastUpdated: LocalDateTime? = null,
    var market: String?,
    var ticker: String?,
){
    fun toEntity(): AssetEntity {
        return AssetEntity(
            id = id,
            portfolio = Portfolio(id = portfolioId).toEntity(),
            type = type,
            name = name,
            broker = broker,
            currency = currency,
            totalQuantity = totalQuantity,
            pricePerUnit = pricePerUnit,
            transactions = transactions.map { it.toEntity() }.toMutableList(),
            lastUpdated = lastUpdated,
            market = market,
            ticker = ticker
        )
    }
}