package gameV3.entities.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonWraith(name: String = "Малиновый Призрак", description: String = "Питается от ягодного лорда...", health: Long = 750, attackPower: Long = 25, defensePower: Long = 0, level: Int) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

}