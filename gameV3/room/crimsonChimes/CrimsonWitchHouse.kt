package gameV3.room.crimsonChimes

import gameV3.entities.EntityFactory
import gameV3.entities.crimsonChimes.CrimsonWitch
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonWitchHouse() : Room(name = "Дом ведьмы", description = "Уууууу!") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private val factory = EntityFactory()

    private fun fillRoom(game: Game) {
        this.enemies.add(CrimsonWitch(level = game.player.level + Random.nextInt(-2, 2)))
        val rand = Random.nextInt(3, 5)
        repeat (rand) {
            this.enemies.add(factory.crimsonFieldOneGenerator(game))
        }
    }
}