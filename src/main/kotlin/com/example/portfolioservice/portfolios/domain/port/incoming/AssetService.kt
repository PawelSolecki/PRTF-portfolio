package com.example.portfolioservice.portfolios.domain.port.incoming

import com.example.portfolioservice.portfolios.application.dto.asset.AddAssetDTO
import com.example.portfolioservice.portfolios.application.dto.asset.PatchAssetDTO
import com.example.portfolioservice.portfolios.domain.model.Asset
import java.util.*

interface AssetService {

    fun createAsset(asset: AddAssetDTO) : Asset

    fun getAssetById(id: UUID): Asset

    fun getAssetsByPortfolioId(portfolioId: UUID): List<Asset>

    fun updateAsset(id:UUID, asset: PatchAssetDTO)

    fun deleteAsset(id: UUID)

}