package gameV3.entities.crimsonChimes

import gameV3.effects.CrimsonEffect
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonBeetle(name : String = "Малиновый Жук", description : String = "Просто жук", health : Long = 50, attackPower : Long = 10, defensePower : Long = 0, level : Int) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
        target.addEffect(CrimsonEffect(2, 0.75))
    }
}