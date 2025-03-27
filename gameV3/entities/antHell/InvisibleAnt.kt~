package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class InvisibleAnt(name: String = "Невидимый Ант", description: String = "Непростой ант", health: Long = 150, attackPower: Long = 10, defensePower: Long = 0, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun receiveDamage(weapon: Weapon?, damage: Long) {
        val random = Random.nextInt(4)
        if (random == 0) {
            super.receiveDamage(weapon, damage)
        } else {
            println("Невидимый Ант не получил урона.")
        }
    }
}