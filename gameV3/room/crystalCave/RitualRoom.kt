package gameV3.room.crystalCave

import gameV3.entities.EntityFactory
import gameV3.entities.crystalCavern.CrystalPriest
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class RitualRoom: Room(name = "Комната ритуала", description = "Вы находитесь в комнате ритуала") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        }
        if (!room.hasEnemies()){
            handleEmptyRoom(game)
        }
    }

    private val factory = EntityFactory()

    private fun fillRoom(game: Game) {
        this.enemies.add(CrystalPriest(level = game.player.level + Random.nextInt(-2, 2)))
        repeat(Random.nextInt(1,5)) {
            this.enemies.add(factory.caveCrystalGenerator(game))
        }
    }
}