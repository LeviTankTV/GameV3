package gameV3.entities.allies.summonable

import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class SlidingCrystalWormAlly(name: String = "Кристальный Червь", description: String = "Ползущая и скользкая опасность", health: Long = 200, attackPower: Long = 20, defensePower: Long = 20, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun receiveDamage(weapon: Weapon?, damage: Long) {
        if (Random.nextInt(2) == 0) {
            super.receiveDamage(weapon, damage)
        } else {
            super.receiveDamage(weapon, 0)
        }
    }

}