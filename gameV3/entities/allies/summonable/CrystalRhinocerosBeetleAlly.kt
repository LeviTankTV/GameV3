package gameV3.entities.allies.summonable

import gameV3.entities.crystalCavern.CrystalMob
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalRhinocerosBeetleAlly(name: String = "Кристальный Жук - Носорог", description: String = "Очень опасный жук", health: Long = 375, attackPower: Long = 80, defensePower: Long = 80, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}