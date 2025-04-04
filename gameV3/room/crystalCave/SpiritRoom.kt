package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.GlowingCrystalSpirit
import gameV3.entities.crystalCavern.HeadyCrystalSpirit
import gameV3.entities.crystalCavern.LavaSpirit
import gameV3.entities.crystalCavern.ShadowCrystalSpirit
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class SpiritRoom: Room(name = "Комната духов", description = "Вы находитесь в комнате духов") {
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
        repeat(Random.nextInt(1, 5)) {
            val spirits = listOf(
                HeadyCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
                GlowingCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
                ShadowCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
                LavaSpirit(level = game.player.level + Random.nextInt(-2, 2))
            )

            this.enemies.add(spirits[Random.nextInt(0, spirits.size)])
        }
    }
}