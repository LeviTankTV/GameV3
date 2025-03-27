package gameV3.entities.antHell

import gameV3.effects.BleedingEffect
import gameV3.effects.BurningEffect
import gameV3.effects.PoisonEffect
import gameV3.entities.Entity
import gameV3.item.other.WizardEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class WizardAnt(name: String = "Муравей - Волшебник", description: String = "Просто ант", health: Long = 175, attackPower: Long = 45, defensePower: Long = 20, level: Int ) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val action = Random.nextInt(4)
        when (action) {
            0 -> {
                val targets = getTargets(game)
                val target = targets[Random.nextInt(targets.size)]
                target.addEffect(BurningEffect(2, 50))
                println("Волшебник кидает огненное зелье в ${target.name}.")
            }
            1 -> {
                val targets = getTargets(game)
                val target = targets[Random.nextInt(targets.size)]
                target.addEffect(BleedingEffect(2, 50))
                println("Волшебник кидает отравленное зелье в ${target.name}.")
            }
            2 -> {
                val targets = getTargets(game)
                val target = targets[Random.nextInt(targets.size)]
                target.addEffect(PoisonEffect(2, 50))
                println("Волшебник кидает ядовитое зелье в ${target.name}.")
            }
            3 -> {
                val targets = getTargets(game)
                for (target in targets) {
                    this.attack(null, target)
                    println("Волшебник атакует ${target.name} бурей мгновенного урона.")
                }
            }
        }
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)

        val random = Random
        if (random.nextInt(10) == 0) {
            game.player.inventory.addItem(WizardEgg())
        }
    }
}