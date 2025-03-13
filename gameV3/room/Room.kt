package gameV3.room

import gameV3.entities.Entity
import gameV3.main.Game

abstract class Room(val name: String, val description: String) {
    var enemies: List<Entity> = listOf();
    var previousRoom: Room? = null
    var nextRoom: Room? = null
    abstract fun playerTurn(game: Game, room: Room)
    fun hasEnemies(): Boolean {
        return enemies.isNotEmpty()
    }
    fun handleCombat() {
        // TODO do combat
    }


}