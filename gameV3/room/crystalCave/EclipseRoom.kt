package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.Unknown
import gameV3.main.Game
import gameV3.room.Room

class EclipseRoom : Room(name = "Зона Контроля №1", description = "Вы находитесь в зоне контроля") {
    override fun playerTurn(game: Game, room: Room) {
        println("Это последний рубеж контроля. Вы видите тёмных существ.")
        repeat(4) { room.enemies.add(Unknown()) }
        handleCombat(game, this)
        if (!room.hasEnemies()) {
            handleEmptyRoom(game)
        }
    }
}