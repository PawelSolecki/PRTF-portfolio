package com.example.portfolioservice.portfolios.domain.port.incoming

import com.example.portfolioservice.portfolios.application.dto.asset.AddAssetDTO
import com.example.portfolioservice.portfolios.application.dto.asset.PatchAssetDTO
import com.example.portfolioservice.portfolios.domain.model.Asset
import java.util.UUID

interface AssetService {

    fun createAsset(asset: AddAssetDTO)

    fun getAssetById(id: UUID): Asset

    fun getAssetsByPortfolioId(portfolioId: UUID): List<Asset>

    fun updateAsset(asset: PatchAssetDTO)

    fun deleteAsset(id: UUID)

}