package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalTroll(name: String = "Кристальный Тролль", description: String = "Очень опасный тролль", health: Long = 500, attackPower: Long = 50, defensePower: Long = 50, level: Int ) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}