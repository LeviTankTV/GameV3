package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.ShadowCrystalSpirit
import gameV3.entities.crystalCavern.ShadowCrystalWarrior
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class DarkRoom: Room(name = "Темная комната", description = "Вы находитесь в темной комнате") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        }
        if (!room.hasEnemies()) {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(2, 6)) {
            if (Random.nextBoolean()) {
                this.enemies.add(ShadowCrystalWarrior(level = game.player.level + Random.nextInt(-2, 2)))
            } else {
                this.enemies.add(ShadowCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)))
            }
        }
    }
}