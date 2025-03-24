package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class SoldierAnt(name : String = "Муравей - Солдат", description : String = "муравей", health : Long = 100, attackPower : Long = 40, defensePower : Long = 12, level : Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

}