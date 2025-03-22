package gameV3.item.weapon.staffs

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class OldCrimsonStaff: Weapon(name = "Старая Малиновый Посох", description = "Сделан из ягод забытой малины") {

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(3, 2.25))
    }

    override var damage: Long = 15
}