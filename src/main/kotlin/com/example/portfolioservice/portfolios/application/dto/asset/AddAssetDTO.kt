package com.example.portfolioservice.portfolios.application.dto.asset

import com.example.portfolioservice.portfolios.domain.model.AssetType

data class AddAssetDTO(
    val type: AssetType,
    val name: String,
    val market: String?,
    val ticker: String?

)
