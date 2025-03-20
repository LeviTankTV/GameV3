package gameV3.effects

import gameV3.entities.Entity

open class Effect(duration: Int) {
    var duration = 0

    open fun apply(entity: Entity){}
    open fun remove(entity: Entity){}
    open fun update(entity: Entity){}
}