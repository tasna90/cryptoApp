package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import com.example.cryptoapp.data.remote.dto.CoinEventDto

interface CoinRepository {

    suspend fun getCoins(
        currency: String,
        order: String,
        perPage: String,
        page: String,
        sparklineSwitch: String
    ) : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto

    suspend fun getCoinEventsByCoinId(coinId: String) : List<CoinEventDto>
}