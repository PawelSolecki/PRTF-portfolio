package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.port.outgoing.AssetRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.mapper.EntitiesMapper
import java.util.*

class AssetJpaRepositoryAdapter(
    private val assetJpaRepository: AssetJpaRepository,
    private val mapper: EntitiesMapper
) : AssetRepository {
    override fun save(asset: Asset) {
        assetJpaRepository.save(mapper.toEntity(asset))
    }

    override fun getAssetById(id: UUID): Asset {
        return mapper.toDomain(assetJpaRepository.findById(id).get())
    }

    override fun getAssetsByPortfolioId(portfolioId: UUID): List<Asset> {
        return assetJpaRepository.findAll().map { mapper.toDomain(it) }
    }

    override fun update(asset: Asset) {
        assetJpaRepository.save(mapper.toEntity(asset))
    }

    override fun deleteAsset(id: UUID) {
        assetJpaRepository.deleteById(id)
    }
}