package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.CrystalMimic
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class MimicRoom: Room(name = "Комната мимика", description = "Вы находитесь в комнате мимика") {
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
        repeat(Random.nextInt(1,2)) {
            this.enemies.add(CrystalMimic(level = game.player.level + Random.nextInt(-2, 2), health = game.player.health, attackPower = game.player.attackPower, defensePower = game.player.defensePower))
        }
    }
}