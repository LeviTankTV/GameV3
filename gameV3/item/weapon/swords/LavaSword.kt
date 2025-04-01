package gameV3.item.weapon.swords

import gameV3.effects.BurningEffect
import gameV3.entities.Entity
import gameV3.item.weapon.Weapon

class LavaSword() : Weapon(name = "Лавовый Клинок", description = "Клинок из чистой лавы") {
    override var damage: Long = 75

    override fun applySpecialEffect(target: Entity) {
        target.addEffect(BurningEffect(3, 80))
    }
}