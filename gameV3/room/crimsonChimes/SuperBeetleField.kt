package gameV3.room.crimsonChimes

import gameV3.entities.bosses.SuperBeetle
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class SuperBeetleField() : Room(name = "Поле Супер Жука", description = "Босс битва") {
    override fun playerTurn(game: Game, room: Room) {
        room.enemies.add(SuperBeetle(level = game.player.level + Random.nextInt(1, 10)))
        handleCombat(game, this)
        if (!room.hasEnemies()) {
            handleEmptyRoom(game)
        }
    }
}