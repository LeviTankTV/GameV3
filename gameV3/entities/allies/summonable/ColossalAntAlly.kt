package gameV3.entities.allies.summonable

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ColossalAntAlly(name: String = "Колоссальный Ант", description: String = "Огромный муравей", health: Long = 300, attackPower: Long = 10, defensePower: Long = 30, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}