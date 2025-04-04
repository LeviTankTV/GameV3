package gameV3.item.weapon.gloves

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class CrimsonGloves: Weapon(name = "Малиновые Перчатки", description = "Перчатки из ягод малины") {

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(4, 0.9))
    }

    override var damage: Long = 15

}