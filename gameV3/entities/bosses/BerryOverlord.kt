package gameV3.entities.bosses

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class BerryOverlord(name: String = "Ягодный Оверлорд", description: String = "Очень опасный босс", health: Long = 1000, attackPower: Long = 100, defensePower: Long = 100, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        TODO("Not yet implemented")
    }
}