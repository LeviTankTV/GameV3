package gameV3.entities.crystalCavern

import gameV3.item.throwable.Rock
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class RockCrystal(name: String = "Каменный Кристаль", description: String = "Кристаль", health: Long = 1750, attackPower: Long = 0, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Каменный Кристаль просто мирно стоит.")
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(Rock())
        }
    }
}