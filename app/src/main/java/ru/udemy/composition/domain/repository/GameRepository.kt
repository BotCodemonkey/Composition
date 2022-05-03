package ru.udemy.composition.domain.repository

import ru.udemy.composition.domain.entity.GameSettings
import ru.udemy.composition.domain.entity.Level
import ru.udemy.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question
    fun getGameSettings(level: Level): GameSettings

}