package gameV3.room.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room
import kotlin.system.exitProcess

class CrimsonChimesEntranceRoom(name: String = "Вход в малиновую рощу", description: String = "Вы находитесь в входе в малиновую рощу") : Room(name, description) {
    override fun playerTurn(game: Game, room: Room) {
        println("Вы вошли в малиновую рощу и видите путь вперед.")
        println("Продолжить приключение? (да/нет)")
        val input = readlnOrNull()
        if (input == "нет") {
            println("Спасибо за игру!")
            exitProcess(0)
        } else if (input == "да") {
            game.moveForward()
        }
    }
}