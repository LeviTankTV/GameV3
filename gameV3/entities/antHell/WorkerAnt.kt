package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.item.consumable.Corn
import gameV3.item.consumable.Leaf
import gameV3.item.other.WorkerEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random


class WorkerAnt(name: String = "Рабочий Ант", description: String = "Просто ант", health: Long = 125, attackPower: Long = 10, defensePower: Long = 8, level: Int ) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)

        val random = Random

        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(Leaf())
        }

        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(Corn())
        }

        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(WorkerEgg())
        }

    }
}