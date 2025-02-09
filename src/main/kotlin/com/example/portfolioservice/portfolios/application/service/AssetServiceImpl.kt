package com.example.portfolioservice.portfolios.application.service

import com.example.portfolioservice.portfolios.application.dto.asset.AddAssetDTO
import com.example.portfolioservice.portfolios.application.dto.asset.PatchAssetDTO
import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.port.incoming.AssetService
import com.example.portfolioservice.portfolios.domain.port.outgoing.AssetRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AssetServiceImpl(
    val assetRepository: AssetRepository
): AssetService {
    override fun createAsset(asset: AddAssetDTO) {
        assetRepository.save(asset.toDomain(UUID.randomUUID()))
    }

    override fun getAssetById(id: UUID): Asset {
        return assetRepository.getAssetById(id)
    }

    override fun getAssetsByPortfolioId(portfolioId: UUID): List<Asset> {
        return assetRepository.getAssetsByPortfolioId(portfolioId)
    }

    override fun updateAsset(asset: PatchAssetDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteAsset(id: UUID) {
        assetRepository.deleteAsset(id)
    }

}