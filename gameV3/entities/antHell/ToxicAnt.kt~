package gameV3.entities.antHell

import gameV3.effects.PoisonEffect
import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ToxicAnt(name: String = "Токсичный Ант", description: String = "Токсичный муравей", health: Long = 75, attackPower: Long = 0, defensePower: Long = 15, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        target.addEffect(PoisonEffect(2, 60))
    }
}