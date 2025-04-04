package gameV3.entities.allies.summonable

import gameV3.entities.crystalCavern.CrystalMob
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ShadowCrystalSpiritAlly(name: String = "Тень Кристального Духа", description: String = "Очень опасный дух", health: Long = 225, attackPower: Long = 30, defensePower: Long = 10, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}