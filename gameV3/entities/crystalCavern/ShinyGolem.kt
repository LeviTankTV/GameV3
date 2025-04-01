package gameV3.entities.crystalCavern

import gameV3.item.other.GoldBar
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ShinyGolem(name: String = "Светящийся Голем", description: String = "Редкий голем", health: Long = 500, attackPower: Long = 10, defensePower: Long = 50, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        val random = Random
        if (random.nextInt(4) == 0) {
            game.player.inventory.addItem(GoldBar())
        }
    }
}