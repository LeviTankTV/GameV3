package gameV3.entities.allies.summonable

import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class NinjaAntAlly(name : String = "Ниндзя Ант", description : String = "Просто ант", health : Long = 50, attackPower : Long = 10, defensePower : Long = 0, level : Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
        println("Ниндзя Ант атаковал ${target.name} сюрикеном.")
    }

    override fun receiveDamage(weapon: Weapon?, damage: Long) {
        val dodged = Random.nextInt(4) == 0
        if (!dodged) {
            super.receiveDamage(weapon, damage)
        } else {
            println("Ниндзя Ант уклонился от удара.")
        }
    }
}