package com.example.portfolioservice.portfolios.application.dto.asset

import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.model.AssetType
import com.example.portfolioservice.portfolios.domain.model.Currency
import java.util.*

data class AddAssetDTO(
    val portfolioId: UUID,
    val type: AssetType,
    val name: String,
    val broker: String,
    val currency: Currency,
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
            market = market,
            ticker = ticker
        )
    }
}
