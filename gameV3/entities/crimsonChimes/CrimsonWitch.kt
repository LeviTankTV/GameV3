package gameV3.entities.crimsonChimes

import gameV3.effects.CrimsonEffect
import gameV3.effects.PoisonEffect
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonWitch(name: String = "Малиновая Ведьма", description: String = "Очень опасная ведьма", health: Long = 100, attackPower: Long = 20, defensePower: Long = 0, level: Int = 1): CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        val action = Random.nextInt(5)

        when (action) {
            0 -> {
                target.addEffect(CrimsonEffect(2, 1.15))
                println("Ведьма кидает малиновое зелье в ${target.name}.")
            }
            1 -> {
                target.addEffect(PoisonEffect(2, 80))
                println("Ведьма кидает отравленное зелье в ${target.name}.")
            }
            2 -> {
                val dmg = Random.nextLong(50, 150)
                target.receiveDamage(null, dmg)
                println("Ведьма кидает зелье мгновенного урона в ${target.name}.")
            }
            3 -> {
                room.enemies.add(PoisonousButterfly(level = game.player.level + Random.nextInt(-2, 2)))
                room.enemies.add(PoisonousButterfly(level = game.player.level + Random.nextInt(-2, 2)))
                println("Ведьма призывает отравленных бабочек!")
            }
            4 -> {
                room.enemies.add(CrimsonChimesMoth(level = game.player.level + Random.nextInt(-2, 2)))
                room.enemies.add(CrimsonChimesMoth(level = game.player.level + Random.nextInt(-2, 2)))
                println("Ведьма призывает мотыльков!")
            }
        }
    }
}