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
        transactionJpaRepository.save(mapper.toEntity(transaction))
    }

    override fun getTransactionById(id: UUID): Transaction {
        return mapper.toDomain(transactionJpaRepository.findById(id).get())
    }

    override fun getTransactionsByAssetId(assetId: UUID): List<Transaction> {
        return transactionJpaRepository.findAll().map { mapper.toDomain(it) }
    }

    override fun update(transaction: Transaction) {
        transactionJpaRepository.save(mapper.toEntity(transaction))
    }

    override fun delete(id: UUID) {
        transactionJpaRepository.deleteById(id)
    }
}