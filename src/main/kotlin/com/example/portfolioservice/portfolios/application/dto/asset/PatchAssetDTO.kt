package com.example.portfolioservice.portfolios.application.dto.asset

import com.example.portfolioservice.portfolios.domain.model.AssetType
import com.example.portfolioservice.portfolios.domain.model.Currency

data class PatchAssetDTO(
    val type: AssetType,
    val name: String,
    val broker: String,
    val currency: Currency,
    val market: String?,
    val ticker: String?,
)