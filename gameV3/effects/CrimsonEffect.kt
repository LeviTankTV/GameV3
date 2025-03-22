package gameV3.effects

import gameV3.entities.Entity

class CrimsonEffect(duration: Int, private val incomeDamageIncreasePercentage: Double) : Effect(duration) {
    override fun apply(entity: Entity) {
        entity.addEffect(this)
    }

    override fun remove(entity: Entity) {
        entity.removeEffect(this)
    }

    override fun update(entity: Entity) {
        duration--
        entity.incomeDamageIncreasePercentage += incomeDamageIncreasePercentage
        if (duration == 0) {
            remove(entity)
            entity.incomeDamageIncreasePercentage -= incomeDamageIncreasePercentage
        }
    }
}