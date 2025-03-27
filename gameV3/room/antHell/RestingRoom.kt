package gameV3.room.antHell

import gameV3.main.Game
import gameV3.room.Room

class RestingRoom() : Room(name = "Комната отдыха", description = "Вы находитесь в комнате отдыха") {
    override fun playerTurn(game: Game, room: Room) {
        println("\nВы находитесь в комнате отдыха.")
        handleEmptyRoom(game)
    }
}