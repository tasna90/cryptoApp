package com.example.cryptoapp.data.remote.dto

import com.example.cryptoapp.domain.model.Coin
import com.google.gson.annotations.SerializedName
import java.math.RoundingMode
import java.text.DecimalFormat

data class CoinDto(
    val ath: Double,
    @SerializedName("ath_change_percentage")
    val athChangePercentage: Double,
    @SerializedName("ath_date")
    val athDate: String,
    val atl: Double,
    @SerializedName("atl_change_percentage")
    val atlChangePercentage: Double,
    @SerializedName("atl_date")
    val atlDate: String,
    @SerializedName("circulating_supply")
    val circulatingSupply: Double,
    @SerializedName("current_price")
    val currentPrice: Double,
    @SerializedName("fully_diluted_valuation")
    val fullyDilutedValuation: Double,
    @SerializedName("high_24h")
    val high24h: Double,
    val id: String,
    val image: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("low_24h")
    val low24h: Double,
    @SerializedName("market_cap")
    val marketCap: Double,
    @SerializedName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerializedName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    @SerializedName("max_supply")
    val maxSupply: Double,
    val name: String,
    @SerializedName("price_change_24h")
    val priceChange24h: Double,
    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    val roi: Any?,
    @SerializedName("sparkline_in_7d")
    val sparklineIn7d: SparklineIn7d,
    val symbol: String,
    @SerializedName("total_supply")
    val totalSupply: Double,
    @SerializedName("total_volume")
    val totalVolume: Double
)

fun CoinDto.toCoin(): Coin{
    val decimalFormat = DecimalFormat("##.##")
    decimalFormat.roundingMode = RoundingMode.DOWN

    return Coin(
        ath = ath,
        athChangePercentage = athChangePercentage,
        athDate = athDate,
        atl = atl,
        atlChangePercentage = atlChangePercentage,
        atlDate = atlDate,
        circulatingSupply = circulatingSupply,
        currentPrice = currentPrice,
        fullyDilutedValuation = fullyDilutedValuation,
        high24h = high24h,
        id = id,
        image = image,
        lastUpdated = lastUpdated,
        low24h = low24h,
        marketCap = marketCap,
        marketCapChange24h = marketCapChange24h,
        marketCapChangePercentage24h = marketCapChangePercentage24h,
        marketCapRank = marketCapRank,
        maxSupply = maxSupply,
        name = name,
        priceChange24h = priceChange24h,
        priceChangePercentage24h = String.format("%.3f", priceChangePercentage24h),
        roi = roi ?: "",
        sparklineIn7d = sparklineIn7d,
        symbol = symbol,
        totalSupply = totalSupply,
        totalVolume = totalVolume
    )
}