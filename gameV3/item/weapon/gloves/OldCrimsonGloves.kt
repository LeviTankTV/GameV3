package gameV3.item.weapon.gloves

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class OldCrimsonGloves: Weapon(name = "Старые Малиновые Перчатки", description = "Перчатки из ягод забытой малины") {

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(8, 2.0))
    }

    override var damage: Long = 1
}