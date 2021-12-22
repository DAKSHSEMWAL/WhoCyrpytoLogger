package com.dakshsemwal.whologger.data.remote

import com.dakshsemwal.whologger.data.remote.dto.CoinDetailsDto
import com.dakshsemwal.whologger.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto

}