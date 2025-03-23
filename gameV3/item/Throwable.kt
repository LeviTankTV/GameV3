package gameV3.item

import gameV3.entities.Entity
import gameV3.main.Game

open class Throwable(name: String, description: String): Item(name, description) {

    open fun throwAt(target: Entity) {}

}