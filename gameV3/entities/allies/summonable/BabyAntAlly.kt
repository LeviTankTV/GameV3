package gameV3.entities.allies.summonable

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class BabyAntAlly(name: String = "Бейби Ант", description: String = "Безобидный малыш", health: Long = 50, attackPower: Long = 0, defensePower: Long = 0, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Бейби Ант не хочет биться")
    }
}