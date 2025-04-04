package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.SinisterCrystalGuardian
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalVault: Room(name = "Зона Контроля №3", description = "Зона Контроля №3") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        println("Вы чувствуете, что уже близко к сердцу пещеры.")
        Thread.sleep(2000)
        println("Из недр пещеры к вам направляются сильные стражники...")
        println("Похоже, бой неизбежен.")
        Thread.sleep(2000)
        waitForEnter()

        if (hasEnemies()) {
            handleCombat(game, room)
        }

        if (!hasEnemies()) {
            handleEmptyRoom(game)
        }

    }

    private fun fillRoom(game: Game) {
        repeat(3) {
            this.enemies.add(SinisterCrystalGuardian(level = game.player.level + Random.nextInt(1, 9)))
        }
    }
}