package gameV3.entities.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonChimesMoth(name : String = "Малиновый Мотылек", description : String = "Оно тебя сожрёт!", health : Long = 80, attackPower : Long = 8, defensePower : Long = 25, level : Int) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

}