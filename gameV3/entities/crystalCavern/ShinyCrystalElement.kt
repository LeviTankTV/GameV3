package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room

class ShinyCrystalElement(name: String = "Сияющий Кристальный Элемент", description: String = "Просто элемент", health: Long = 500, attackPower: Long = 0, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Сияющий Кристальный Элемент просто сияет.")
    }
}