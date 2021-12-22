package com.dakshsemwal.whologger.domain.model

import com.dakshsemwal.whologger.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description :String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
){
    override fun toString(): String {
        return "CoinDetail(coinId='$coinId', name='$name', description='$description', symbol='$symbol', rank=$rank, isActive=$isActive, tags=$tags, team=$team)"
    }
}
