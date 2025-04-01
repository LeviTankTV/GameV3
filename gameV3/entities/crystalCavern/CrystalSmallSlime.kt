package gameV3.entities.crystalCavern

import gameV3.item.other.CrystalSmallSlimeEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalSmallSlime(name: String = "Малый Слайм", description: String = "Просто слайм", health: Long = 125, attackPower: Long = 20, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Маленький слайм просто смотрит на вас.")
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(CrystalSmallSlimeEgg())
        }
    }
}