package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.AssetEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AssetJpaRepository : JpaRepository<AssetEntity, UUID> {
}