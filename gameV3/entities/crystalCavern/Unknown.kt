package gameV3.entities.crystalCavern

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class Unknown(name: String = "???", description: String = "???", health: Long = 17500, attackPower: Long = 0, defensePower: Long = 0, level: Int = 1) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Существо не реагирует на взаимодействие и исчезает.")
        room.enemies.remove(this)
    }
}