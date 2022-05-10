package com.example.cryptoapp.domain.model

import com.example.cryptoapp.data.remote.dto.SparklineIn7d

data class Coin(
    val ath: Double,
    val athChangePercentage: Double,
    val athDate: String,
    val atl: Double,
    val atlChangePercentage: Double,
    val atlDate: String,
    val circulatingSupply: Double,
    val currentPrice: Double,
    val fullyDilutedValuation: Double,
    val high24h: Double,
    val id: String,
    val image: String,
    val lastUpdated: String,
    val low24h: Double,
    val marketCap: Double,
    val marketCapChange24h: Double,
    val marketCapChangePercentage24h: Double,
    val marketCapRank: Int,
    val maxSupply: Double,
    val name: String,
    val priceChange24h: Double,
    val priceChangePercentage24h: String,
    val roi: Any,
    val sparklineIn7d: SparklineIn7d,
    val symbol: String,
    val totalSupply: Double,
    val totalVolume: Double
)
