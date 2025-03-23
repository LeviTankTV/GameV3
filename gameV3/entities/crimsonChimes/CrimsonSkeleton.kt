package gameV3.entities.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonSkeleton(name: String = "Малиновый Скелет", description: String = "Выглядит так, будто щас развалится", health: Long = 75, attackPower: Long = 35, defensePower: Long = 0, level: Int = 1) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}