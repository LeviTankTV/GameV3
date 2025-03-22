package gameV3.item.weapon.swords

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class CrimsonSword: Weapon(name = "Малиновый Меч", description = "Мощный меч из ягод малины.") {

    override var type = "Crimson"

    override var damage: Long = 20

    override var critChance: Long = 60

    override var critMultiplier: Double = 2.5

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(3, 1.75))
    }
}