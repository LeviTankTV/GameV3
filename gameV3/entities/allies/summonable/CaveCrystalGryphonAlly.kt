package gameV3.entities.allies.summonable

import gameV3.entities.crystalCavern.CrystalMob
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CaveCrystalGryphonAlly(name: String = "Кристальный Грифон", description: String = "Очень опасный грифон", health: Long = 250, attackPower: Long = 50, defensePower: Long = 50, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}