package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room

class HeadyCrystalSpirit(name: String = "Дурманящий Кристальный Дух", description: String = "Очень опасный Дух", health: Long = 100, attackPower: Long = 20, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val allies = room.enemies.filter{t -> t != this}
        for (ally in allies) {
            ally.attackPower += 35
            println("${ally.name} был усилен дурманящим кристаллом!")
            this.health = 0
        }
    }
}