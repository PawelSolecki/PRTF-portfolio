package com.example.portfolioservice.portfolios.application.dto.portfolio

import com.example.portfolioservice.portfolios.domain.model.Portfolio
import java.util.*

data class AddPortfolioDTO(
    val name: String,

){
    fun toDomain(id: UUID): Portfolio {
        return Portfolio(
            name = name,
            ownerId = id,
        )
    }
}
