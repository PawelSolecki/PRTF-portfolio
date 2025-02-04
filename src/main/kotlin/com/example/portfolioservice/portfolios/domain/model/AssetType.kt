package com.example.portfolioservice.portfolios.domain.model

enum class AssetType(val displayNameEn: String, val displayNamePl: String) {
    STOCK("Stock", "Akcja"),
    BOND("Bond", "Obligacja"),
    COMMODITY("Commodity", "Surowiec"),
    CRYPTO("Cryptocurrency", "Kryptowaluta"),
    ETF("Exchange Traded Fund", "Fundusz ETF"),
    MUTUAL_FUND("Mutual Fund", "Fundusz Inwestycyjny")
}
