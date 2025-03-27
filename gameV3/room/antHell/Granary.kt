package gameV3.room.antHell

import gameV3.entities.antHell.AlarmAnt
import gameV3.entities.antHell.WorkerAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Granary() : Room(name = "Кладовая", description = "Вы находитесь в кладовой") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, room)
        } else {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        for(i in 1..6) {
            val random = Random.nextInt(100)
            if (random <= 90) {
                this.enemies.add(WorkerAnt(level = game.player.level + Random.nextInt(-2, 2)))
            }
            else if (random <= 100) {
                this.enemies.add(AlarmAnt(level = game.player.level + Random.nextInt(-2, 2)))
            }
        }
    }
}