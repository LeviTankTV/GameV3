package gameV3.room.antHell

import gameV3.entities.EntityFactory
import gameV3.entities.antHell.RescueAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class HealingRoom() : Room(name = "Лечебная комната", description = "Вы находитесь в лечебной комнате") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private val factory = EntityFactory()

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(2, 5)) {
            this.enemies.add(RescueAnt(level = game.player.level + Random.nextInt(-2, 2)))
        }
        repeat(Random.nextInt(2, 3)) {
            this.enemies.add(factory.antGenerator(game))
        }
    }
}