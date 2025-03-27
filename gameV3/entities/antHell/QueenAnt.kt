package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.entities.EntityFactory
import gameV3.item.consumable.Wing
import gameV3.item.other.SoldierEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class QueenAnt(name: String = "Королева Муравьев", description: String = "Муравей", health: Long = 500, attackPower: Long = 50, defensePower: Long = 0, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        summonTurns++
        if (summonTurns == maxSummonTurns) {
            room.enemies.add(factory.antGenerator(game))
        }
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }
    private var summonTurns = 0
    private val maxSummonTurns = 3
    private val factory = EntityFactory()

    override fun dropLoot(game: Game) {
        super.dropLoot(game)

        val random = Random
        game.player.inventory.addItem(SoldierEgg())
        game.player.inventory.addItem(Wing())
        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(SoldierEgg())
        }
        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(SoldierEgg())
        }
        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(SoldierEgg())
        }

    }
}