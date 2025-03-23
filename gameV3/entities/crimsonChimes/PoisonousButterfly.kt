package gameV3.entities.crimsonChimes

import gameV3.effects.PoisonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class PoisonousButterfly(name: String = "Отравленная Бабочка", description: String = "Очень опасная бабочка", health: Long = 10, attackPower: Long = 10, defensePower: Long = 0, level: Int): CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
        val poisonDamage = Random.nextLong(40)
        target.addEffect(PoisonEffect(2, poisonDamage))
    }
}