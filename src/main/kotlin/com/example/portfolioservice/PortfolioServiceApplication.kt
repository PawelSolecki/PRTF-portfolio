package com.example.portfolioservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.example.portfolioservice")
class PortfolioServiceApplication

fun main(args: Array<String>) {
    runApplication<PortfolioServiceApplication>(*args)
}
