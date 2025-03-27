package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class SkeletonAnt(name: String = "Муравей - Скелет", description: String = "Просто ант", health: Long = 125, attackPower: Long = 10, defensePower: Long = 0, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    private var resurrect = false

    override fun receiveDamage(weapon: Weapon?, damage: Long) {
        super.receiveDamage(weapon, damage)
        if (health <= 0 && !resurrect) {
            resurrect = true
            health = 125
            println("Муравей - Скелет восстал из мертвых.")
        }
    }
}