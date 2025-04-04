package gameV3.entities.crystalCavern

import gameV3.item.weapon.swords.LavaSword
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class FireGuardian(name: String = "Огненный Страж", description: String = "Очень опасный страж", health: Long = 325, attackPower: Long = 40, defensePower: Long = 100, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(LavaSword(), target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(LavaSword())
        }
    }
}