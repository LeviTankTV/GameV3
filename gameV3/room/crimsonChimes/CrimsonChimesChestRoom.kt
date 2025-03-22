package gameV3.room.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room

class CrimsonChimesChestRoom(name: String = "Комната с сундуком", description: String = "Вы находитесь в комнате с сундуком") : Room(name, description) {

    override fun playerTurn(game: Game, room: Room) {
        openChest(game)
        waitForEnter()
        game.moveForward()
    }
}