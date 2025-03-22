package gameV3.entities.darkForest

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class WoodenGuardian(name: String = "Древесный Страж", description: String = "один из приспешников сердца леса", health: Long = 1000, attackPower: Long = 125, defensePower: Long = 100, level: Int ) : Entity(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}