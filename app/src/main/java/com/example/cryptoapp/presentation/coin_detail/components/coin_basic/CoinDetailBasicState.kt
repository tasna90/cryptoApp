package com.example.cryptoapp.presentation.coin_detail.components.coin_basic

import com.example.cryptoapp.domain.model.CoinDetail

data class CoinDetailBasicState (
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)