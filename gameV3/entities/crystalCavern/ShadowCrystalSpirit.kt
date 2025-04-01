package gameV3.entities.crystalCavern

import gameV3.item.other.ShadowCrystalBook
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ShadowCrystalSpirit(name: String = "Тень Кристального Духа", description: String = "Очень опасный дух", health: Long = 525, attackPower: Long = 30, defensePower: Long = 10, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(ShadowCrystalBook())
        }
    }
}