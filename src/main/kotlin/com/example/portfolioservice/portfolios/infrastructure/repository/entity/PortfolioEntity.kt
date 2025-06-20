package com.example.portfolioservice.portfolios.infrastructure.repository.entity

import com.example.portfolioservice.portfolios.domain.model.Portfolio
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "portfolios")
class PortfolioEntity @JvmOverloads constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false)
    val ownerId: UUID? = null,

    @Column(nullable = false)
    val name: String = "",

    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val assets: MutableList<AssetEntity> = mutableListOf(),

    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val allocations: MutableList<PortfolioAllocationEntity> = mutableListOf(),

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime? = LocalDateTime.now(),

    @Column(nullable = false)
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = LocalDateTime.now(),

    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val totalValues: MutableList<PortfolioTotalValueEntity> = mutableListOf()

){

    fun toDomain(): Portfolio{
        return Portfolio(
            id = id,
            ownerId = ownerId,
            name = name,
            assets = assets.map { it.toDomain() }.toMutableList(),
            allocations = allocations.map { it.toDomain() }.toMutableList(),
            createdAt = createdAt,
            updatedAt = updatedAt,
            totalValue = totalValues.map { it.currency to it.value }.toMap()
        )
    }
}