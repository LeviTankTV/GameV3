package gameV3.room.antHell

import gameV3.entities.EntityFactory
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class TunnelChamber(): Room(name = "Туннель", description = "Вы находитесь в туннеле") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        } else {
            handleEmptyRoom(game)
        }
    }

    private val factory = EntityFactory()

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(1, 10)) {
            this.enemies.add(factory.antGenerator(game))
        }
    }
}