package gameV3.item.throwable

import gameV3.entities.Entity
import gameV3.item.Throwable

class CrystalDagger: Throwable(name = "Кристальный кинжал", description = "Кристальный кинжал") {
    override fun throwAt(target: Entity) {
        target.health -= 360
        println("Вы бросили кристальный кинжал в ${target.name}!")
    }
}