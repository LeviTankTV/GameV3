package gameV3.effects

import gameV3.entities.Entity

class InvisibilityEffect(duration: Int): Effect(duration) {

    override fun apply(entity: Entity) {
        entity.isInvisible = true
    }

    override fun remove(entity: Entity) {
        entity.isInvisible = false
        entity.removeEffect(this)
    }

    override fun update(entity: Entity) {
        duration--
        if (duration == 0) {
            remove(entity)
        }
    }

}