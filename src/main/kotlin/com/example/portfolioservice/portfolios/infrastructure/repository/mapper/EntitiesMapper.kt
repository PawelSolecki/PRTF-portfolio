package com.example.portfolioservice.portfolios.infrastructure.repository.mapper

import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.model.Portfolio
import com.example.portfolioservice.portfolios.domain.model.Transaction
import com.example.portfolioservice.portfolios.infrastructure.repository.entity.AssetEntity
import com.example.portfolioservice.portfolios.infrastructure.repository.entity.PortfolioEntity
import com.example.portfolioservice.portfolios.infrastructure.repository.entity.TransactionEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface EntitiesMapper {

    fun toDomain(entity: PortfolioEntity): Portfolio
    fun toEntity(domain: Portfolio): PortfolioEntity

    fun toDomain(entity: AssetEntity): Asset
    fun toEntity(domain: Asset): AssetEntity

    fun toDomain(entity: TransactionEntity): Transaction
    fun toEntity(domain: Transaction): TransactionEntity
}