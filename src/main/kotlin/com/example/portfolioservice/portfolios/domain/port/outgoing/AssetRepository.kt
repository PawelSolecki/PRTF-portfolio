package com.example.portfolioservice.portfolios.domain.port.outgoing

import com.example.portfolioservice.portfolios.domain.model.Asset
import java.util.*

interface AssetRepository {
    fun save(asset: Asset)

    fun getAssetById(id: UUID): Asset

    fun getAssetsByPortfolioId(portfolioId: UUID): List<Asset>

    fun update(asset: Asset)

    fun deleteAsset(id: UUID)
}