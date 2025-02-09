package com.example.portfolioservice.portfolios.application.service

import com.example.portfolioservice.portfolios.application.dto.transaction.AddTransactionDTO
import com.example.portfolioservice.portfolios.application.dto.transaction.PatchTransactionDTO
import com.example.portfolioservice.portfolios.domain.model.Transaction
import com.example.portfolioservice.portfolios.domain.port.incoming.TransactionService
import com.example.portfolioservice.portfolios.domain.port.outgoing.TransactionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionServiceImpl(
    val transactionRepository: TransactionRepository
) : TransactionService {
    override fun createTransaction(transaction: AddTransactionDTO) {
        transactionRepository.save(transaction.toDomain())
    }

    override fun getTransactionById(id: UUID): Transaction {
        return transactionRepository.getTransactionById(id)
    }

    override fun getTransactionsByAssetId(assetId: UUID): List<Transaction> {
        return transactionRepository.getTransactionsByAssetId(assetId)
    }

    override fun updateTransaction(transaction: PatchTransactionDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(id: UUID) {
        transactionRepository.delete(id)
    }

}