package gameV3.room.antHell

import gameV3.entities.EntityFactory
import gameV3.entities.antHell.AntEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Nest() : Room(name = "Гнездо", description = " Вы находитесь в гнезде") {
    override fun playerTurn(game: Game, room: Room) {
        repeat(Random.nextInt(10) + 1) {
            room.enemies.add(AntEgg(level = game.player.level + Random.nextInt(-2, 2)))
        }
        if (room.hasEnemies()) {
            handleCombat(game, this)
        } else {
            handleEmptyRoom(game)
        }
    }
}