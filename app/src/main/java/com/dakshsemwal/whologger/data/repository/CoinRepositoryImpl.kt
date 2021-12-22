package com.dakshsemwal.whologger.data.repository

import com.dakshsemwal.whologger.data.remote.CoinPaprikaApi
import com.dakshsemwal.whologger.data.remote.dto.CoinDetailsDto
import com.dakshsemwal.whologger.data.remote.dto.CoinDto
import com.dakshsemwal.whologger.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api:CoinPaprikaApi):CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId : String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }


}