package com.example.cryptoapp.presentation.coin_detail.components.coin_events

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.domain.use_case.GetEventsForCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailEventsViewModel @Inject constructor(
    private val getCoinEventsForCoinUseCase: GetEventsForCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailEventsState())
    val state: State<CoinDetailEventsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getEventsForCoin(coinId)
        }
    }

    fun getEventsForCoin(coinId: String) {
        getCoinEventsForCoinUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailEventsState(events = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinDetailEventsState(error = result.message ?:
                    "An unexpected error happened.")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailEventsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}