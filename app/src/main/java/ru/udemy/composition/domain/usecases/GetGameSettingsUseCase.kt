package ru.udemy.composition.domain.usecases

import ru.udemy.composition.domain.entity.GameSettings
import ru.udemy.composition.domain.entity.Level
import ru.udemy.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }

}