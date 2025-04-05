package gameV3.room.crystalCave

import gameV3.entities.EntityFactory
import gameV3.entities.crimsonChimes.FireBeetle
import gameV3.entities.crystalCavern.*
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class LavaLake: Room(name = "Комната лавы", description = "Вы находитесь в комнате лавы") {
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
        repeat(Random.nextInt(1, 5)) {
            val rand = Random.nextInt(6)
            when (rand) {
                0 -> this.enemies.add(LavaSpirit(level = game.player.level + Random.nextInt(-2, 2)))
                1 -> this.enemies.add(LavaCrystal(level = game.player.level + Random.nextInt(-2, 2)))
                2 -> this.enemies.add(FireGuardian(level = game.player.level + Random.nextInt(-2, 2)))
                3 -> this.enemies.add(FireBeetle(level = game.player.level + Random.nextInt(-2, 2)))
                4 -> this.enemies.add(CrystalVampire(level = game.player.level + Random.nextInt(-2, 2)))
                5 -> this.enemies.add(IgneousCrystal(level = game.player.level + Random.nextInt(-2, 2)))
            }
        }
    }
}