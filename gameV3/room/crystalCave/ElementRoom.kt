package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.*
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ElementRoom: Room(name = "Элементальная комната", description = "Вы находитесь в элементальной комнате") {
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
        repeat(Random.nextInt(1, 4)) {
            val enemies = listOf(
                LavaCrystal(level = game.player.level + Random.nextInt(-2, 2)),
                ShadowCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
                CaveCrystal(level = game.player.level + Random.nextInt(-2, 2)),
                RockCrystal(level = game.player.level + Random.nextInt(-2, 2)),
                ShinyCaveCrystal(level = game.player.level + Random.nextInt(-2, 2)),
                HeadyCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
                IgneousCrystal(level = game.player.level + Random.nextInt(-2, 2)),
                LavaSpirit(level = game.player.level + Random.nextInt(-2, 2)),
                GlowingCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
                ShinyCrystalElement(level = game.player.level + Random.nextInt(-2, 2)),
            )
            this.enemies.add(enemies[Random.nextInt(0, enemies.size)])
        }
    }
}