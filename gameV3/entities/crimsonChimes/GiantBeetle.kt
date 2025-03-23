package gameV3.entities.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class GiantBeetle(name : String = "Огромный Жук", description : String = "Просто огромный жук", health : Long = 400, attackPower : Long = 40, defensePower : Long = 20, level : Int) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}