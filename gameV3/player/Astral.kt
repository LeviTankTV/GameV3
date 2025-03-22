package gameV3.player

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Astral(name: String = "Астрал", description: String = "Ваш главный помощник в данном приключении", health: Long = 10000, attackPower: Long = 0, defensePower: Long = 0, level: Int = 1) : Entity(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val enemies = room.enemies
        val random = Random.nextInt(enemies.size)
        val enemy = enemies[random]
        val player = game.player
        val action = Random.nextInt(2)
        when (action) {
            0 -> this.attack(null , enemy)
            1 -> this.heal(game)
        }

    }

    private fun heal(game: Game) {
        game.player.health += Random.nextInt(50) + game.player.level * 5
    }

}