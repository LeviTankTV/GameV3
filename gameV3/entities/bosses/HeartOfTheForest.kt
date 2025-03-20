package gameV3.entities.bosses

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class HeartOfTheForest(name : String = "Сердце леса", description : String = "Хранитель многих тайн", health : Int = 55555, attackPower : Int = 800, defensePower : Int = 200, level : Int = 1): Entity(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {

    }
}