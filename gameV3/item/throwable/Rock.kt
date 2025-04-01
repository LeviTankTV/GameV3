package gameV3.item.throwable

import gameV3.entities.Entity
import gameV3.item.Throwable

class Rock: Throwable(name = "Камень", description = "Очень тяжелый камень") {
    override fun throwAt(target: Entity) {
        target.health -= 500
        println("Вы бросили камень в ${target.name}!")
    }
}