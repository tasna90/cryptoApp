package com.example.cryptoapp.domain.model

data class CoinEvent(
    val date: String,
    val dateTo: String,
    val description: String,
    val id: String,
    val isConference: Boolean,
    val link: String,
    val name: String
    )