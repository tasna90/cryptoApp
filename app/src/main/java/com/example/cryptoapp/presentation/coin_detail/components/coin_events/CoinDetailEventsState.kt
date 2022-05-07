package com.example.cryptoapp.presentation.coin_detail.components.coin_events

import com.example.cryptoapp.domain.model.CoinEvent

data class CoinDetailEventsState(
    val isLoading: Boolean = false,
    val events: List<CoinEvent> = emptyList(),
    val error: String = ""
)