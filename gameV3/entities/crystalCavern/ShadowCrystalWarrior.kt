package gameV3.entities.crystalCavern

import gameV3.item.consumable.Crystal
import gameV3.item.throwable.CrystalDagger
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ShadowCrystalWarrior(name: String = "Темный Кристальный Воин", description: String = "Очень опасный воин", health: Long = 1200, attackPower: Long = 275, defensePower: Long = 80, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        game.player.inventory.addItem(Crystal())
        game.player.inventory.addItem(CrystalDagger())
    }
}