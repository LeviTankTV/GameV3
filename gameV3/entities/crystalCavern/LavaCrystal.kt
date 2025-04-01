package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room

class LavaCrystal(name: String = "Лавовый Кристалл", description: String = "Чистая лава", health: Long = 750, attackPower: Long = 0, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val allies = room.enemies.filter {t -> t != this}
        for (ally in allies) {
            ally.attackPower += 2
            println("${ally.name} был усилен лавовым кристаллом!")
        }
    }
}