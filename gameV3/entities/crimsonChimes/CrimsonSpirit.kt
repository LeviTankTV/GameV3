package gameV3.entities.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room

class CrimsonSpirit(name : String = "Малиновый Дух", description : String = "Огромный прозрачный малиновый дух", health : Long = 800, attackPower : Long = 0, defensePower : Long = 0, level : Int) : CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Малиновый дух просто смотрит на вас.")
    }

    override fun dropLoot(game: Game) {
        // do nothing
    }
}