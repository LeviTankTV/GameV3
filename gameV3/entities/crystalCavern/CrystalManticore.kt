package gameV3.entities.crystalCavern

import gameV3.item.other.CrystalManticoreEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalManticore(name: String = "Кристальный Мантикор", description: String = "Очень опасный мантикор", health: Long = 500, attackPower: Long = 50, defensePower: Long = 50, level: Int ) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
        if (target.health > 0 && Random.nextInt(2) == 0) {
            this.attack(null, target)
        }
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(CrystalManticoreEgg())
        }
    }
}