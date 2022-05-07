package com.example.cryptoapp.domain.use_case

import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.data.remote.dto.toCoinEvent
import com.example.cryptoapp.domain.model.CoinEvent
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEventsForCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<List<CoinEvent>>> = flow {
           try {
                emit(Resource.Loading<List<CoinEvent>>())
                val events = repository.getCoinEventsByCoinId(coinId).map { it.toCoinEvent() }
                emit(Resource.Success<List<CoinEvent>>(events))
           } catch(e: HttpException) {
                emit(Resource.Error<List<CoinEvent>>(e.localizedMessage ?: "An unexpected error happened."))
           } catch(e: IOException) {
                emit(Resource.Error<List<CoinEvent>>("Couldn't reach server. Check your internet connection."))
           }
    }
}