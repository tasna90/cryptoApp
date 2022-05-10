package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import com.example.cryptoapp.data.remote.dto.CoinEventDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface CoinGeckoApi {

    @GET("/api/v3/coins/markets")
    suspend fun getCoins(@Query("vs_currency") currency: String,
                         @Query("order") order: String,
                         @Query("per_page") perPage: String,
                         @Query("page") page: String,
                         @Query("sparkline") sparkline: String) : List<CoinDto>

    @GET("/api/v3/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto

    @GET("/v1/coins/{coinId}/events")
    suspend fun getCoinEventsByCoinId(@Path("coinId") coinId: String) : List<CoinEventDto>
}