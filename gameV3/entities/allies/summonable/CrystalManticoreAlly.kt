package gameV3.entities.allies.summonable

import gameV3.entities.crystalCavern.CrystalMob
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalManticoreAlly(name: String = "Кристальный Мантикор", description: String = "Очень опасный мантикор", health: Long = 275, attackPower: Long = 40, defensePower: Long = 40, level: Int ) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
        if (target.health > 0 && Random.nextInt(2) == 0) {
            this.attack(null, target)
        }
    }
}