package gameV3.room.darkForest

import gameV3.main.Game
import gameV3.room.Room
import kotlin.system.exitProcess

class DarkForestRoom(name: String, description: String) : Room(name, description) {

    override fun playerTurn(game: Game, room: Room) {
        game.usedAstralAdvice = false
        if (game.darkForestRoomStepsCounter != 7) {
            room.handleEmptyRoom(game)
        } else {
            println("В темноте вы видите лесной лабиринт. Выберите действие:")
            println("1. Идти в лабиринт")
            println("2. Посидеть и отдохнуть")

            val input = readlnOrNull()
            when (input) {
                "1" -> {
                    game.currentRoom = DarkForestMaze("Лесной Лабиринт", "Вы находитесь в лесном лабиринте. Вам нужно найти выход.")
                    game.previousRoom = null
                }
                "2" -> {
                    game.napCounter++
                    if (game.napCounter == 10) {
                        game.player.health = 0
                        println("Вы уснули и вас съели монстры.")
                        exitProcess(0)
                    }
                    playerTurn(game, room)
                }
                else -> println("Непонятная команда. Попробуйте снова.")
            }
        }
    }
}

