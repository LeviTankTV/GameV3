package gameV3.player.spells

import gameV3.effects.BleedingEffect
import gameV3.effects.BurningEffect
import gameV3.effects.CrimsonEffect
import gameV3.effects.PoisonEffect
import gameV3.entities.Entity
import kotlin.random.Random

class ArcaneMissile() : Spell(name = "Магический Снаряд") {
    override fun cast(target: Entity) {
        val random = Random.nextInt(4)
        when (random) {
            0 -> target.addEffect(PoisonEffect(3, (target.level * 8).toLong()))
            1 -> target.addEffect(BleedingEffect(3, (target.level * 8).toLong()))
            2 -> target.addEffect(BurningEffect(3, (target.level * 8).toLong()))
            3 -> target.addEffect(CrimsonEffect(3, 2.5))
        }
    }
}