package gameV3.room.antHell

import gameV3.entities.antHell.*
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class HuntingChamber() : Room(name = "Зал охоты", description = "Вы находитесь в зале охоты") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        } else {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(1, 7)) {
            val random = Random.nextInt(4)
            when (random) {
                0 -> this.enemies.add(SoldierAnt(level = game.player.level + Random.nextInt(-2, 2)))
                1 -> this.enemies.add(DemolitionAnt(level = game.player.level + Random.nextInt(-2, 2)))
                2 -> this.enemies.add(ColossalAnt(level = game.player.level + Random.nextInt(-2, 2)))
                3 -> this.enemies.add(RescueAnt(level = game.player.level + Random.nextInt(-2, 2)))
            }
        }
    }
}