package gameV3.room.crystalCave

import gameV3.entities.bosses.PossessedGolem
import gameV3.main.Game
import gameV3.room.Room

class Jail : Room(name = "Jail Room № A.B.Y.S.S", description = "???") {
    override fun playerTurn(game: Game, room: Room) {
        println("Вы входите в тюрьму...")
        Thread.sleep(2000)
        println("Вы видите голема, который полностью окутан тьмой...")
        Thread.sleep(2000)
        println("Вам не остаётся выбора, кроме как уничтожить его.")
        Thread.sleep(2000)
        waitForEnter()

        this.enemies.add(PossessedGolem())
        handleCombat(game, room)

        if (!hasEnemies()) {
            println("Вы уничтожили голема...")
            Thread.sleep(2000)
            println("Изнутри него выходит тьма, которая затягивает всю вашу команду...")
            Thread.sleep(2000)
            println("Тьма Поглотила вас...")
            Thread.sleep(2000)
            waitForEnter()

            game.gameTransition(4)
        }
    }
}