package com.example.portfolioservice.portfolios.infrastructure.repository.entity

import com.example.portfolioservice.portfolios.domain.model.Currency
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name="portfolio_total_values")
class PortfolioTotalValueEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    val portfolio: PortfolioEntity? = null,

    @Column(nullable = false)
    val currency: Currency = Currency.PLN,

    @Column(nullable = false, precision = 19, scale = 4)
    val value: BigDecimal = BigDecimal.ZERO
)