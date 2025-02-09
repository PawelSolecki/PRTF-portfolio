package com.example.portfolioservice.portfolios.infrastructure.repository.entity

import com.example.portfolioservice.portfolios.domain.model.Transaction
import com.example.portfolioservice.portfolios.domain.model.TransactionType
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "transactions")
class TransactionEntity(
    @Id
    @GeneratedValue
    val id: UUID? = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    var asset: AssetEntity? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: TransactionType? = null,

    @Column(nullable = false, precision = 19, scale = 4)
    val quantity: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false, precision = 19, scale = 4)
    val pricePerUnit: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    val date: LocalDateTime? = LocalDateTime.now()
) {
    fun toDomain(): Transaction {
        return Transaction(
            id = id,
            assetId = asset?.id!!,
            type = type,
            quantity = quantity,
            pricePerUnit = pricePerUnit,
            date = date
        )

    }
}