package gameV3.entities.bosses

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class PossessedGolem(name: String = "Одержимый Голем", description: String = "Невероятно нестабильная сущность.", health: Long = 1, attackPower: Long = 1, defensePower: Long = 1, level: Int = 1) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Он уже давно мёртв внутри.")
    }
}