package gameV3.item.weapon.bows

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class CrimsonBow: Weapon(name = "Малиновый лук", description = "Мощный лук из ягод малины.") {

    override var type = "Crimson"
    override var damage: Long = 30

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(2, 0.75))
    }
}