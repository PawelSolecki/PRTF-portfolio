package com.example.portfolioservice.portfolios.domain.port.outgoing

import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.model.AssetType
import java.math.BigDecimal
import java.util.*

interface AssetRepository {
    fun save(asset: Asset)

    fun getAssetById(id: UUID): Asset

    fun getAssetsByPortfolioId(portfolioId: UUID): List<Asset>

    fun update(asset: Asset)

    fun deleteAsset(id: UUID)

    fun calculateAssetsValues(portfolioId: UUID): Map<AssetType, BigDecimal>
}