package com.example.portfolioservice.portfolios.infrastructure.utils

interface Utils {
    fun <T : Any, P : Any> patch(target: T, patchDto: P): T

}