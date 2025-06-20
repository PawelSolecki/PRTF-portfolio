package com.example.portfolioservice.portfolios.infrastructure.adapter

import com.fasterxml.jackson.annotation.JsonAnySetter
import java.math.BigDecimal

data class RawExchangeRateResponse(
    val date: String,

    @JsonAnySetter
    val currencies: MutableMap<String, Map<String, BigDecimal>> = mutableMapOf()
)
