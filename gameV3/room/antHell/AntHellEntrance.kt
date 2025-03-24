package gameV3.room.antHell

import gameV3.main.Game
import gameV3.room.Room

class AntHellEntrance(name : String = "Вход в муравейник", description : String = "Ад.") : Room(name, description) {
    override fun playerTurn(game: Game, room: Room) {
        handleEmptyRoom(game)
    }
}