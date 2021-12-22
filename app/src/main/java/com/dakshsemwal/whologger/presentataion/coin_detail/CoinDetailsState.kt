package com.dakshsemwal.whologger.presentataion.coin_detail

import com.dakshsemwal.whologger.domain.model.Coin
import com.dakshsemwal.whologger.domain.model.CoinDetail

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)
