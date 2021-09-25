package com.company.speed.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Card(
    val rank: Int,
    val suit: Suit,
    @PrimaryKey val id: Int? = null
) {
    companion object {

    }
}

