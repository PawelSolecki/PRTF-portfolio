package com.example.portfolioservice.portfolios.application.dto.asset

import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.model.AssetType
import com.example.portfolioservice.portfolios.domain.model.Currency
import java.math.BigDecimal
import java.util.*

data class AddAssetDTO(
    val portfolioId: UUID,
    val type: AssetType,
    val name: String,
    val broker: String,
    val currency: Currency,
    val pricePerUnit: BigDecimal,
    val market: String?,
    val ticker: String?,

) {
    fun toDomain(id: UUID): Asset {
        return Asset(
            id = id,
            portfolioId = portfolioId,
            type = type,
            name = name,
            broker = broker,
            currency = currency,
            pricePerUnit = pricePerUnit,
            market = market,
            ticker = ticker
        )
    }
}
