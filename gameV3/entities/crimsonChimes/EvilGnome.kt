package gameV3.entities.crimsonChimes

import gameV3.item.weapon.gloves.CrimsonGloves
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class EvilGnome(name: String = "Злой Гном", description: String = "Опасный гном", health: Long = 225, attackPower: Long = 45, defensePower: Long = 0, level: Int = 1): CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        val allies = room.enemies
        val ally = allies[Random.nextInt(allies.size)]
        val action = Random.nextInt(2)

        when (action) {
            0 -> this.attack(weapon, target)
            1 -> {
                val healAmount = Random.nextLong(100)
                ally.health += healAmount
                println("Гном увеличил здоровье ${ally.name} на $healAmount.")
            }
        }
    }
}