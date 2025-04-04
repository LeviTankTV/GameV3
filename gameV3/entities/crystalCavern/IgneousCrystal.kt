package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room

class IgneousCrystal(name: String = "Кристалл из магмы", description: String = "Чистая магма", health: Long = 1550, attackPower: Long = 0, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val allies = room.enemies.filter {t -> t != this}
        for (ally in allies) {
            ally.attackPower += 5
            println("${ally.name} был усилен лавовым кристаллом!")
        }
    }
}