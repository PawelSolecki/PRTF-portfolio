package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.infrastructure.repository.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TransactionJpaRepository : JpaRepository<TransactionEntity, UUID> {
}