package gameV3.entities.allies

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class Ally(name: String, description: String, health: Long, attackPower: Long, defensePower: Long, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        super.performAction(game, room)
    }

}