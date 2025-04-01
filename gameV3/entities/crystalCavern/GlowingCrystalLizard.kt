package gameV3.entities.crystalCavern

import gameV3.item.other.GlowingCrystalLizardEgg
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class GlowingCrystalLizard(name: String = "Сияющая кристальная ящерица", description: String = "Бегающая ящерица", health: Long = 150, attackPower: Long = 20, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun receiveDamage(weapon: Weapon?, damage: Long) {
        super.receiveDamage(weapon, damage)
        if (health <= 0 && !resurrect) {
            resurrect = true
            health = 150
            println("Cияющая кристальная ящерица восстала из мертвых.")
        }
    }

    private var resurrect = false

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(GlowingCrystalLizardEgg())
        }
    }
}