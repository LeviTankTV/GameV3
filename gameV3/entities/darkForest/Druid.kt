package gameV3.entities.darkForest

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Druid(name: String = "Друид", description: String = "один из приспешников сердца леса", health: Long = 1000, attackPower: Long = 125, defensePower: Long = 100, level: Int ) : Entity(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val astral = game.player.astral
        val playerAllies = game.player.allies
        val targets = listOf(astral,game.player) + playerAllies
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
}