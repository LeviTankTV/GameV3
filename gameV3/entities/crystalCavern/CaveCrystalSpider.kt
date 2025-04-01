package gameV3.entities.crystalCavern

import gameV3.effects.PoisonEffect
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CaveCrystalSpider(name: String = "Кристальный Паук", description: String = "Очень маленький паук", health: Long = 50, attackPower: Long = 10, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        target.addEffect(PoisonEffect(5, 40))
    }
}