package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class QueenAnt(name: String = "Королева Муравьев", description: String = "Муравей", health: Long = 500, attackPower: Long = 50, defensePower: Long = 0, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        TODO("Not yet implemented")
    }
}