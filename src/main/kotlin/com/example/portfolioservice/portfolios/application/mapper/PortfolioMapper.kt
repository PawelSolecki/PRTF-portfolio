package com.example.portfolioservice.portfolios.application.mapper

import com.example.portfolioservice.portfolios.application.dto.portfolio.AddPortfolioDTO
import com.example.portfolioservice.portfolios.application.dto.portfolio.PatchPortfolioDTO
import com.example.portfolioservice.portfolios.domain.model.Portfolio
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PortfolioMapper {
    fun toDomain(dto: AddPortfolioDTO): Portfolio

    fun toDomain(dto: PatchPortfolioDTO): Portfolio
}