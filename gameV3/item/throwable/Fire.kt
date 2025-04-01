package gameV3.item.throwable

import gameV3.effects.BurningEffect
import gameV3.entities.Entity
import gameV3.item.MultiThrowable

class Fire() : MultiThrowable(name = "Огонь", description = "Огонь") {
    override fun throwAt(targets: List<Entity>) {
        for (target in targets) {
            target.health -= 80
            target.addEffect(BurningEffect(2, 120))
        }
    }
}