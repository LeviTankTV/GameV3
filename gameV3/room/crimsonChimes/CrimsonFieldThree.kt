package gameV3.room.crimsonChimes

import gameV3.entities.EntityFactory
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonFieldThree() : Room(name = "Малиновое поле", description = "Третий уровень") {

    override fun playerTurn(game: Game, room: Room) {
        fillRoomWithEnemies(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private val factory = EntityFactory()

    private fun fillRoomWithEnemies(game: Game) {
        val rand = Random.nextInt(1, 3)
        for (i in 1..rand) {
            this.enemies.add(factory.crimsonFieldThreeGenerator(game))
        }
    }
}