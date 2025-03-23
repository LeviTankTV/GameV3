package gameV3.item.consumable

import gameV3.effects.PoisonEffect
import gameV3.entities.Entity
import gameV3.item.Consumable
import gameV3.item.Throwable
import gameV3.main.Game

class PoisonPotion: Throwable(name = "Взрывное зелье яда", description = "Его можно кинуть на врага!") {
    override fun throwAt(target: Entity) {
        target.addEffect(PoisonEffect(3, 80))
    }
}