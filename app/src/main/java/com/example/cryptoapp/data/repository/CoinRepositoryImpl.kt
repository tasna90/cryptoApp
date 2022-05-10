package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.CoinGeckoApi
import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import com.example.cryptoapp.data.remote.dto.CoinEventDto
import com.example.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinGeckoApi
) : CoinRepository {

    override suspend fun getCoins(
        currency: String,
        order: String,
        perPage: String,
        page: String,
        sparklineSwitch: String
    ) : List<CoinDto> {
        return api.getCoins(
            currency,
            order,
            perPage,
            page,
            sparklineSwitch
        )
    }

    override suspend fun getCoinById(coinId: String) : CoinDetailDto {
        return api.getCoinById(coinId)
    }

    override suspend fun getCoinEventsByCoinId(coinId: String) : List<CoinEventDto> {
        return api.getCoinEventsByCoinId(coinId)
    }

}