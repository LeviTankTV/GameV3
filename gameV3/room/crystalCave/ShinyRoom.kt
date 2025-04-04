package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.ShinyBug
import gameV3.entities.crystalCavern.ShinyCaveCrystal
import gameV3.entities.crystalCavern.ShinyCrystalElement
import gameV3.entities.crystalCavern.ShinyGolem
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ShinyRoom: Room(name = "Блестящая комната", description = "Вы находитесь в блестящей комнате") {
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
        this.enemies.add(ShinyCaveCrystal(level = game.player.level + Random.nextInt(-2, 2)))
        repeat(Random.nextInt(1, 3)) {
            val shinyEnemies = listOf(
                ShinyCaveCrystal(level = game.player.level + Random.nextInt(-2, 2)),
                ShinyBug(level = game.player.level + Random.nextInt(-2, 2)),
                ShinyCrystalElement(level = game.player.level + Random.nextInt(-2, 2)),
                ShinyGolem(level = game.player.level + Random.nextInt(-2, 2))
            )
            this.enemies.add(shinyEnemies[Random.nextInt(0, shinyEnemies.size)])
        }
    }
}