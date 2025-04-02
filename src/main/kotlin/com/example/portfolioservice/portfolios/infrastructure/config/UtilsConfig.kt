package com.example.portfolioservice.portfolios.infrastructure.config

import com.example.portfolioservice.portfolios.infrastructure.utils.Utils
import com.example.portfolioservice.portfolios.infrastructure.utils.UtilsImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UtilsConfig {

    @Bean
    fun utils(): Utils {
        return UtilsImpl()
    }
}