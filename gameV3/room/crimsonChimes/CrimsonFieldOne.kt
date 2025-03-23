package gameV3.room.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonFieldOne() : Room(name = "Малиновое поле", description = "Первый уровень") {

    override fun playerTurn(game: Game, room: Room) {
        fillRoomWithEnemies(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoomWithEnemies(game: Game) {
        val rand = Random.nextInt(1, 7)
    }
}