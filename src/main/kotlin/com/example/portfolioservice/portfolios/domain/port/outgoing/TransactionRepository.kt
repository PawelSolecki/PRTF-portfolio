package com.example.portfolioservice.portfolios.domain.port.outgoing

import com.example.portfolioservice.portfolios.domain.model.Transaction
import java.util.*

interface TransactionRepository {

    fun save(transaction: Transaction)

    fun getTransactionById(id: UUID): Transaction

    fun getTransactionsByAssetId(assetId: UUID): List<Transaction>

    fun update(transaction: Transaction)

    fun delete(id: UUID)
}