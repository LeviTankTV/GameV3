package gameV3.entities.crystalCavern

import gameV3.item.other.SlidingCrystalWormEgg
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class SlidingCrystalWorm(name: String = "Кристальный Червь", description: String = "Ползущая и скользкая опасность", health: Long = 200, attackPower: Long = 20, defensePower: Long = 20, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
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

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(SlidingCrystalWormEgg())
        }
    }

}