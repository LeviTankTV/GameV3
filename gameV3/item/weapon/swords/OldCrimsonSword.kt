package gameV3.item.weapon.swords

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class OldCrimsonSword: Weapon(name = "Старый малиновый меч", description =  "Сделан из ягод забытой малины") {

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(3, 3.5))
    }

    override var damage: Long = 25
}