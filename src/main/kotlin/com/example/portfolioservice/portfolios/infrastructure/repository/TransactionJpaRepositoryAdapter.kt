package com.example.portfolioservice.portfolios.infrastructure.repository

import com.example.portfolioservice.portfolios.domain.model.Transaction
import com.example.portfolioservice.portfolios.domain.port.outgoing.TransactionRepository
import com.example.portfolioservice.portfolios.infrastructure.repository.mapper.EntitiesMapper
import java.util.*

class TransactionJpaRepositoryAdapter(
    private val transactionJpaRepository: TransactionJpaRepository,
    private val mapper: EntitiesMapper
) : TransactionRepository {
    override fun save(transaction: Transaction) {
        val entity = transaction.toEntity()
        transactionJpaRepository.save(entity)
    }

    override fun getTransactionById(id: UUID): Transaction {
        return transactionJpaRepository.findById(id).get().toDomain()
    }

    override fun getTransactionsByAssetId(assetId: UUID): List<Transaction> {
        return transactionJpaRepository.findByAssetId(assetId).map { it.toDomain() }
    }

    override fun update(transaction: Transaction) {
        transactionJpaRepository.save(transaction.toEntity())
    }

    override fun delete(id: UUID) {
        transactionJpaRepository.deleteById(id)
    }
}