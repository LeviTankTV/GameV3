package gameV3.entities.crimsonChimes

import gameV3.effects.PoisonEffect
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class PoisonousBeetle(name : String = "Жук", description : String = "Просто жук", health : Long = 80, attackPower : Long = 10, defensePower : Long = 20, level : Int) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
        target.addEffect(PoisonEffect(2, 15))
    }
}