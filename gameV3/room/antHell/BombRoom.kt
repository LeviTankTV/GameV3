package gameV3.room.antHell

import gameV3.entities.antHell.DemolitionAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class BombRoom() : Room(name = "Комната с подрывниками", description = "Вы находитесь в комнате с подрывниками") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        } else {
            handleEmptyRoom(game)
        }
    }
    
    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(3, 6)) {
            this.enemies.add(DemolitionAnt(level = game.player.level + Random.nextInt(-2, 2)))
        }
    }
}