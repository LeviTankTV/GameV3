package gameV3.entities.crimsonChimes

import gameV3.effects.BurningEffect
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class WailingWisps(name: String = "Пламенный Вихрь", description: String = "~~~~~~~~~~", health: Long = 125, attackPower: Long = 35, defensePower: Long = 35, level: Int) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
        target.addEffect(BurningEffect(3, 30))
    }

}