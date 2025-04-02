package com.example.portfolioservice.portfolios.application.service

import com.example.portfolioservice.portfolios.application.dto.asset.AddAssetDTO
import com.example.portfolioservice.portfolios.application.dto.asset.PatchAssetDTO
import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.port.incoming.AssetService
import com.example.portfolioservice.portfolios.domain.port.outgoing.AssetRepository
import com.example.portfolioservice.portfolios.infrastructure.utils.Utils
import org.springframework.stereotype.Service
import java.util.*

@Service
class AssetServiceImpl(
    val assetRepository: AssetRepository,
    val utils: Utils
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

    override fun updateAsset(id: UUID, newAsset: PatchAssetDTO) {
        val asset: Asset = assetRepository.getAssetById(id)
        val editedAsset = utils.patch(asset, newAsset)

        assetRepository.update(editedAsset)
    }

    override fun deleteAsset(id: UUID) {
        assetRepository.deleteAsset(id)
    }

}