package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.GlowCrystalWorm
import gameV3.entities.crystalCavern.SlidingCrystalWorm
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class WormRoom: Room(name = "Прибежище червяков", description = "Вы находитесь в прибежище червяков") {
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
        repeat(Random.nextInt(1, 7)) {
            val worms = listOf(
                SlidingCrystalWorm(level = game.player.level + Random.nextInt(-2, 2)),
                GlowCrystalWorm(level = game.player.level + Random.nextInt(-2, 2))
            )

            this.enemies.add(worms[Random.nextInt(0, worms.size)])
        }
    }
}