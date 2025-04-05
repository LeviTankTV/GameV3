package gameV3.room.crystalCave

import gameV3.entities.EntityFactory
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Tunnel: Room(name = "Туннель", description = "Вы находитесь в туннеле") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        }
        if (!room.hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(3, 9)) {
            this.enemies.add(EntityFactory().caveCrystalGenerator(game))
        }
    }
}