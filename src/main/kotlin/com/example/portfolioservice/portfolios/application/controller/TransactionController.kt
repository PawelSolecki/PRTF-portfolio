package com.example.portfolioservice.portfolios.application.controller

import com.example.portfolioservice.portfolios.application.dto.transaction.AddTransactionDTO
import com.example.portfolioservice.portfolios.application.dto.transaction.PatchTransactionDTO
import com.example.portfolioservice.portfolios.domain.model.Transaction
import com.example.portfolioservice.portfolios.domain.port.incoming.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/transaction")
class TransactionController(
    val transactionService: TransactionService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTransaction(@RequestBody transaction: AddTransactionDTO) {
        transactionService.createTransaction(transaction)
    }

    @GetMapping("/{id}")
    fun getTransactionById(@PathVariable id: UUID): Transaction {
        return transactionService.getTransactionById(id)
    }

    @GetMapping("/asset/{assetId}")
    fun getTransactionsByAssetId(@PathVariable assetId: UUID): List<Transaction> {
        return transactionService.getTransactionsByAssetId(assetId)
    }

    @PatchMapping
    fun updateTransaction(@RequestBody transaction: PatchTransactionDTO) {
        transactionService.updateTransaction(transaction)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTransaction(@PathVariable id: UUID) {
        transactionService.deleteTransaction(id)
    }


}