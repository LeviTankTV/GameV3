package gameV3.room.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room

class EntranceToAntHell(): Room(name = "Вход в Антхелл", description = "Вы находитесь в комнате с входом в Антхелл") {
    override fun playerTurn(game: Game, room: Room) {
        println("Вы хотите зайти в муравейник? (да/нет)")
        val input = readlnOrNull()
        when (input) {
            "да" -> {
                game.gameStage = -1
                game.generateDungeon()
                game.currentRoom = game.visitedRooms[0]
            }
            "нет" -> {
                println("Вы решили не заходить в муравейник")
            }
        }
    }
}