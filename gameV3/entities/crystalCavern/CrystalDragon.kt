package gameV3.entities.crystalCavern

import gameV3.item.other.GoldBar
import gameV3.item.throwable.Fire
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalDragon(name: String = "Кристальный Дракон", description: String = "Очень опасный дракон", health: Long = 240, attackPower: Long = 120, defensePower: Long = 40, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        for (target in targets) {
            this.attack(null, target)
        }
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(GoldBar())
        }
        if (Random.nextInt(3) == 0) {
            game.player.inventory.addItem(Fire())
        }
    }
}