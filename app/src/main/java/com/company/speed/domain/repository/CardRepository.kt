package com.company.speed.domain.repository

import com.company.speed.domain.model.Card
import kotlinx.coroutines.flow.Flow
import java.util.*

interface CardRepository {

    fun getCards(): List<Card>
    fun shuffleCards(list: List<Card>): List<Card>


}