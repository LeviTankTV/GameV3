package gameV3.player.spells

import gameV3.effects.BurningEffect
import gameV3.entities.Entity

class FireballSpell() : Spell(name = "Огненный шар") {
    override fun cast(target: Entity) {
        target.health -= target.level * 10
        target.addEffect(BurningEffect(3, (target.level * 2).toLong()))
    }
}