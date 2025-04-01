package gameV3.item.throwable

import gameV3.effects.BurningEffect
import gameV3.entities.Entity
import gameV3.item.Throwable

class LavaDagger() : Throwable(name = "Пламенный кинжал", description = "Кинжал из пламени") {
    override fun throwAt(target: Entity) {
        target.health -= 220
        target.addEffect(BurningEffect(3, 120))
    }
}