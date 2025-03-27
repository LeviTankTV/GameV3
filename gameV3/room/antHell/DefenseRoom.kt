package gameV3.room.antHell

import gameV3.entities.antHell.ColossalAnt
import gameV3.entities.antHell.SoldierAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class DefenseRoom() : Room(name = "Защитная комната", description = "Вы находитесь в защитной комнате") {
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
            val random = Random.nextInt(2)
            when (random) {
                0 -> this.enemies.add(SoldierAnt(level = game.player.level + Random.nextInt(-2, 2)))
                1 -> this.enemies.add(ColossalAnt(level = game.player.level + Random.nextInt(-2, 2)))
            }
        }
    }
}