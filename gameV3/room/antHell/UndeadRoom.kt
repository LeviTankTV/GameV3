package gameV3.room.antHell

import gameV3.entities.antHell.SkeletonAnt
import gameV3.entities.antHell.SpiritCrusherAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class UndeadRoom() : Room(name = "Комната с мертвыми муравьями", description = "Вы находитесь в комнате с мертвыми") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        if (room.hasEnemies()) {
            handleCombat(game, this)
        } else {
            handleEmptyRoom(game)
        }
    }

    private fun fillRoom(game: Game) {
        repeat(Random.nextInt(2, 6)) {
            val random = Random.nextInt(10)
            if (random <= 8) {
                this.enemies.add(SkeletonAnt(level = game.player.level + Random.nextInt(-2, 2)))
            } else {
                this.enemies.add(SpiritCrusherAnt(level = game.player.level + Random.nextInt(-2, 2)))
            }
        }
    }
}