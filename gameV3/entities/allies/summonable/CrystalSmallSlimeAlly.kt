package gameV3.entities.allies.summonable

import gameV3.entities.crystalCavern.CrystalMob
import gameV3.main.Game
import gameV3.room.Room

class CrystalSmallSlimeAlly(name: String = "Малый Слайм", description: String = "Просто слайм", health: Long = 125, attackPower: Long = 20, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Маленький слайм просто смотрит на врагов.")
    }
}