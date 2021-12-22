package com.dakshsemwal.whologger.presentataion.coin_list

import com.dakshsemwal.whologger.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
