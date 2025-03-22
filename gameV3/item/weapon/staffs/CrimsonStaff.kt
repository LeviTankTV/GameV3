package gameV3.item.weapon.staffs

import gameV3.effects.CrimsonEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class CrimsonStaff: Weapon(name = "Малиновый Посох", description = "Посох из ягод малины.") {

    override var type = "Crimson"
    override var damage: Long = 50
    override fun applySpecialEffect(target: Entity) {
        target.addEffect(CrimsonEffect(2, 1.0))
    }
}