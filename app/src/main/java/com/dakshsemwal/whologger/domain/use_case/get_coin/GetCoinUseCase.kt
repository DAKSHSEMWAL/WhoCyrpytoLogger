package com.dakshsemwal.whologger.domain.use_case.get_coin

import android.telecom.Call
import android.util.Log
import com.dakshsemwal.whologger.common.Resource
import com.dakshsemwal.whologger.data.remote.dto.toCoinDetail
import com.dakshsemwal.whologger.domain.model.Coin
import com.dakshsemwal.whologger.domain.model.CoinDetail
import com.dakshsemwal.whologger.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinById(coinId).toCoinDetail()
            Log.e("Details","$coinDetail")
            emit(Resource.Success<CoinDetail>(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server.Check your internet connection "))
        }
    }
}