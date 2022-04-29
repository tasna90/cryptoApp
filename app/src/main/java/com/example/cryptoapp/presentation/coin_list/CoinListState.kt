package com.example.cryptoapp.presentation.coin_list

import com.example.cryptoapp.domain.model.Coin

data class CoinListState (
        val isLoading: Boolean = false,
        val error: String = "",
        val coins: List<Coin> = emptyList()
)