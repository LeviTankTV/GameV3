package gameV3.item

import gameV3.entities.Entity

open class MultiThrowable(name: String, description: String) : Item(name, description) {
    open fun throwAt( targets : List<Entity>) {
        TODO("Override in subclasses")
    }
}