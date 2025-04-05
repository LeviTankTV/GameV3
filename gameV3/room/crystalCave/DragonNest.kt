package gameV3.room.crystalCave

import gameV3.entities.EntityFactory
import gameV3.entities.crystalCavern.CrystalDragon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class DragonNest: Room(name = "Гнездо дракона", description = "Вы находитесь в гнезде дракона") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        }
        if (!room.hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private val factory = EntityFactory()

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(2, 4)) {
            this.enemies.add(CrystalDragon(level = game.player.level + Random.nextInt(-2, 2)))
        }
        repeat(Random.nextInt(4)) {
            this.enemies.add(factory.caveCrystalGenerator(game))
        }
    }

}