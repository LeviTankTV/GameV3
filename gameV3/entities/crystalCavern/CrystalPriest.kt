package gameV3.entities.crystalCavern

import gameV3.item.other.HealSpellBook
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalPriest(name: String = "Кристальный Монах", description: String = "Очень опасный монах", health: Long = 400, attackPower: Long = 20, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val allies = room.enemies.filter {t -> t != this}
        if (allies.isNotEmpty()) {
            for (ally in allies) {
                ally.health += 200
                println("${ally.name} был усилен кристальным монахом!")
            }
        }
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(5) == 0) {
            game.player.inventory.addItem(HealSpellBook())
        }
    }
}