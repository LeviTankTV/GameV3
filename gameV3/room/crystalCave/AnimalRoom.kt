package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.*
import gameV3.main.Game
import gameV3.main.main
import gameV3.room.Room
import kotlin.random.Random

class AnimalRoom: Room(name = "Комната с животными", description = "Вы находитесь в комнате с животными") {
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
        this.enemies.add(CrystalPredator(level = game.player.level + Random.nextInt(-2, 2)))
        val enemies = listOf(
            CrystalBigSlime(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalMediumSlime(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalSmallSlime(level = game.player.level + Random.nextInt(-2, 2)),
            GlowCrystalWorm(level = game.player.level + Random.nextInt(-2, 2)),
            SlidingCrystalWorm(level = game.player.level + Random.nextInt(-2, 2)),
            CaveCrystalGryphon(level = game.player.level + Random.nextInt(-2, 2)),
            GlowingCrystalLizard(level = game.player.level + Random.nextInt(-2, 2)),
        )
        repeat(Random.nextInt(1, 7)) {
            this.enemies.add(enemies[Random.nextInt(enemies.size)])
        }
    }
}