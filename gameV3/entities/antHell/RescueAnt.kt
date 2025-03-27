package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.item.consumable.Leaf
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class RescueAnt(name : String = "Муравей - Спасатель", description : String = "Просто ант", health : Long = 75, attackPower : Long = 0, defensePower : Long = 0, level : Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        for (target in targets) {
            target.health += 75
            println("Муравей - Спасатель восстановил здоровье ${target.name}")
        }
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)

        val random = Random
        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(Leaf())
        }
        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(Leaf())
        }

    }
}