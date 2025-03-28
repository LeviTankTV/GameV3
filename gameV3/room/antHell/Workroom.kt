package gameV3.room.antHell

import gameV3.entities.antHell.WorkerAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Workroom() : Room(name = "Рабочая комната", description = "Вы находитесь в рабочей комнате") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        } else {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        val random = Random.nextInt(3,8)
        repeat(random) {
            this.enemies.add(WorkerAnt(level = game.player.level + Random.nextInt(-2, 2)))
        }
    }
}