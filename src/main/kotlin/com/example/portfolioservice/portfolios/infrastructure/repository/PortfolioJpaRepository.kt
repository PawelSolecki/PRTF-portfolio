package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.PortfolioEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PortfolioJpaRepository : JpaRepository<PortfolioEntity, UUID> {
}