package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.model.AssetType
import com.example.portfolioservice.portfolios.domain.port.outgoing.AssetRepository
import java.math.BigDecimal
import java.util.*

class AssetJpaRepositoryAdapter(
    private val assetJpaRepository: AssetJpaRepository,
) : AssetRepository {
    override fun save(asset: Asset) {
        assetJpaRepository.save(asset.toEntity())
    }

    override fun getAssetById(id: UUID): Asset {
        return assetJpaRepository.findById(id).get().toDomain()

    }

    override fun getAssetsByPortfolioId(portfolioId: UUID): List<Asset> {
        return assetJpaRepository.findByPortfolioId(portfolioId).map { it.toDomain() }
    }

    override fun update(asset: Asset) {
        assetJpaRepository.save(asset.toEntity())
    }

    override fun deleteAsset(id: UUID) {
        assetJpaRepository.deleteById(id)
    }

    override fun calculateAssetsValues(portfolioId: UUID): Map<AssetType, BigDecimal> {
        return assetJpaRepository.calculateAssetsValues(portfolioId)
            .associate {
                AssetType.valueOf(it["key"] as String) to (it["value"] as BigDecimal)
            }
    }
}