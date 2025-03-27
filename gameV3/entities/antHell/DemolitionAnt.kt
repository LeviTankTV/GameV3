package gameV3.entities.antHell

import gameV3.effects.BurningEffect
import gameV3.entities.Entity
import gameV3.item.other.DemoEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class DemolitionAnt(name : String = "Муравей - Разрушитель", description : String = "Муравей", health : Long = 125, attackPower : Long = 10, defensePower : Long = 0, level : Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        for (target in targets) {
            this.attack(null, target)
            target.addEffect(BurningEffect(3, 20))
            println("Муравей атакует и поджигает ${target.name}!")
        }
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        val random = Random

        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(DemoEgg())
        }
    }
}