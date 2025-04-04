package gameV3.room.antHell

import gameV3.entities.EntityFactory
import gameV3.entities.antHell.QueenAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class QueenChamber() : Room(name = "Королевская комната", description = "???") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        handleCombat(game, this)
        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private val factory = EntityFactory()

    private fun fillRoom(game: Game) {
        this.enemies.add(QueenAnt(level = game.player.level + Random.nextInt(-2, 2)))
        repeat(Random.nextInt(1, 3)) {
            this.enemies.add(factory.antGenerator(game))
        }
    }
}