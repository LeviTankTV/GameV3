package gameV3.room.crimsonChimes

import gameV3.entities.EntityFactory
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class BeetleField() : Room(name = "Поле жуков", description = "Осторожно! Тут есть жуки") {
    val factory = EntityFactory()

    override fun playerTurn(game: Game, room: Room) {
        fillRoomWithBeetles(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoomWithBeetles(game: Game) {
        val rand = Random.nextInt(2, 10)
        repeat(rand) {
            val beetle = factory.beetleGenerator(game)
            this.enemies.add(beetle)
        }
    }

}