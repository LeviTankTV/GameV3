package gameV3.room.antHell

import gameV3.entities.antHell.ToxicAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ToxicRoom() : Room(name = "Токсичная комната", description = "Токсичная комната") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(3, 8)) {
            this.enemies.add(ToxicAnt(level = game.player.level + Random.nextInt(-2, 2)))
        }
    }
}