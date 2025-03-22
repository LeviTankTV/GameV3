package gameV3.item.weapon.bows

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class OldCrimsonBow: Weapon(name = "Старый малиновый лук", description = "Сделан из ягод забытой малины") {

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(3, 2.25))
    }

    override var damage: Long = 20
}