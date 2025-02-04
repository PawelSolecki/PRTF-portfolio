package com.example.portfolioservice.portfolios.domain.port.incoming

import com.example.portfolioservice.portfolios.application.dto.transaction.AddTransactionDTO
import com.example.portfolioservice.portfolios.application.dto.transaction.PatchTransactionDTO
import com.example.portfolioservice.portfolios.domain.model.Transaction
import java.util.UUID

interface TransactionService {

    fun createTransaction(transaction: AddTransactionDTO)

    fun getTransactionById(id: UUID): Transaction

    fun getTransactionsByAssetId(assetId: UUID): List<Transaction>

    fun updateTransaction(transaction: PatchTransactionDTO)

    fun deleteTransaction(id: UUID)
}