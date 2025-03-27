package gameV3.room.antHell

import gameV3.entities.antHell.InvisibleAnt
import gameV3.entities.antHell.NinjaAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ScoutRoom() : Room(name = "Шпионская комната", description = "Вы находитесь в шпионской комнате") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(2, 5)) {
            val random = Random.nextInt(2)
            when (random) {
                0 -> this.enemies.add(InvisibleAnt(level = game.player.level + Random.nextInt(-2, 2)))
                1 -> this.enemies.add(NinjaAnt(level = game.player.level + Random.nextInt(-2, 2)))
            }

        }
    }
}