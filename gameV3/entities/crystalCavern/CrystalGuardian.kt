package gameV3.entities.crystalCavern

import gameV3.item.weapon.swords.CrystalSword
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalGuardian(name: String = "Кристальный Страж", description: String = "опасный страж", health: Long = 325, attackPower: Long = 30, defensePower: Long = 40, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(CrystalSword(), target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(15) == 0) {
            game.player.inventory.addItem(CrystalSword())
        }
    }
}