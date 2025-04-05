package gameV3.room.antHell

import gameV3.entities.bosses.AntHole
import gameV3.main.Game
import gameV3.room.Room

class AntHoleRoom() : Room(name = "Комната с муравьями", description = "Вы находитесь в комнате с муравьями") {
    override fun playerTurn(game: Game, room: Room) {
        println("\nВы находитесь в комнате с муравьями.")
        Thread.sleep(2000)
        println("Вы понимаете, что за этой комнатой находится выход из муравейника.")
        Thread.sleep(2000)
        println("Походу, это их логово.")
        Thread.sleep(2000)
        println("Вам не остаётся выбора, кроме как уничтожить его.")
        Thread.sleep(2000)
        waitForEnter()

        this.enemies.add(AntHole())
        handleCombat(game, room)

        if (!hasEnemies()) {
            println("Вы уничтожили муравейник.")
            Thread.sleep(2000)
            println("Впереди вы видите кристальную пещеру...")
            Thread.sleep(2000)
            waitForEnter()

            game.gameTransition(3)
        }
    }
}