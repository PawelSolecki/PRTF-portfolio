package com.example.portfolioservice.portfolios.infrastructure.repository.entity

import com.example.portfolioservice.portfolios.domain.model.AssetType
import jakarta.persistence.*
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "assets")
class AssetEntity(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    var portfolio: PortfolioEntity,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: AssetType,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, precision = 19, scale = 4)
    var totalQuantity: BigDecimal,

    @Column(nullable = false)
    @UpdateTimestamp
    var lastUpdated: LocalDateTime = LocalDateTime.now(),

    @Column
    val market: String? = null,

    @Column
    val ticker: String? = null,

    @OneToMany(mappedBy = "asset", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val transactions: MutableList<TransactionEntity> = mutableListOf()
)