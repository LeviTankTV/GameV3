package gameV3.entities

import gameV3.entities.darkForestCreatures.*
import gameV3.main.Game
import gameV3.player.Player
import kotlin.random.Random

class CreatureFactory {

    // Метод для получения случайного существа из темного леса
    fun getRandomDarkForestCreature(game : Game): Creature {
        val playerLevel = game.player.level
        val creatures = listOf(
            ForestMice(level = playerLevel),
            ForestBeetle(level = playerLevel),
            ForestVines(level = playerLevel),
            ForestSprouts(level = playerLevel),
            ForestBat(level = playerLevel)
        )

        // Возвращаем случайное существо из списка
        return creatures[Random.nextInt(creatures.size)]
    }
}