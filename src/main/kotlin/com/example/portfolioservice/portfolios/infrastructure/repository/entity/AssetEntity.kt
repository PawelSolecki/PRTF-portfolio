package com.example.portfolioservice.portfolios.infrastructure.repository.entity

import com.example.portfolioservice.portfolios.domain.model.Asset
import com.example.portfolioservice.portfolios.domain.model.AssetType
import jakarta.persistence.*
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "assets")
class AssetEntity @JvmOverloads constructor(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    var portfolio: PortfolioEntity? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: AssetType? = null,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false, precision = 19, scale = 4)
    var totalQuantity: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    @UpdateTimestamp
    var lastUpdated: LocalDateTime? = LocalDateTime.now(),

    @Column
    val market: String? = null,

    @Column
    val ticker: String? = null,

    @OneToMany(mappedBy = "asset", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val transactions: MutableList<TransactionEntity> = mutableListOf()
) {
    fun toDomain():Asset {
        return Asset(
            id = id,
            portfolioId = portfolio?.id!!,
            type = type,
            name = name,
            totalQuantity = totalQuantity,
            transactions = transactions.map { it.toDomain() }.toMutableList(),
            lastUpdated = lastUpdated,
            market = market,
            ticker = ticker,
        )
    }
}