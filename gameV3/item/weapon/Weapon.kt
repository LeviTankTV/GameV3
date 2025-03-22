package gameV3.item.weapon

import gameV3.entities.Entity
import gameV3.item.Item

open class Weapon(name: String, description: String) : Item(name, description) {

    open var critChance: Long = 0

    open var critMultiplier: Long = 1

    open var damage: Long = 0

    open fun applySpecialEffect(target: Entity) {
        TODO("Implement this method in the subclass")
    }

}