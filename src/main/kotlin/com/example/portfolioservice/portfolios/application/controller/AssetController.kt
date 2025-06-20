package com.example.portfolioservice.portfolios.application.controller

import com.example.portfolioservice.portfolios.application.dto.asset.AddAssetDTO
import com.example.portfolioservice.portfolios.application.dto.asset.PatchAssetDTO
import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.port.incoming.AssetService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/asset")
class AssetController(
    val assetService: AssetService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createAsset(@RequestBody asset: AddAssetDTO, response: HttpServletResponse) {
        val assetId = assetService.createAsset(asset).id
        response.setHeader("Location", "/api/v1/asset/$assetId")

    }

    @GetMapping("/{id}")
    fun getAssetById(@PathVariable id: UUID): Asset {
        return assetService.getAssetById(id)
    }

    @GetMapping("/portfolio/{portfolioId}")
    fun getAssetsByPortfolioId(@PathVariable portfolioId: UUID): List<Asset> {
        return assetService.getAssetsByPortfolioId(portfolioId)
    }

    @PatchMapping("/{id}")
    fun updateAsset(@RequestBody asset: PatchAssetDTO, @PathVariable id: UUID) {
        assetService.updateAsset(id, asset)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAsset(@PathVariable id: UUID) {
        assetService.deleteAsset(id)
    }

}