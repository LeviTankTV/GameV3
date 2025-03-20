package gameV3.player

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Astral(name: String = "Астрал", description: String = "Ваш главный помощник в данном приключении", health: Int = 10000, attackPower: Int = 0, defensePower: Int = 0, level: Int = 1) : Entity(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val enemies = room.enemies
        val random = Random.nextInt(enemies.size)
        val enemy = enemies[random]

    }

}