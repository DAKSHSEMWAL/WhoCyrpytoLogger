package com.dakshsemwal.whologger.domain.repository

import com.dakshsemwal.whologger.data.remote.dto.CoinDetailsDto
import com.dakshsemwal.whologger.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailsDto

}