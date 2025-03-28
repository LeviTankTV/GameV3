package gameV3.effects

import gameV3.entities.Entity

class PoisonEffect(duration: Int, private val damagePerTurn: Long) : Effect(duration) {
    override fun update(entity: Entity) {
        duration--
        entity.receiveDamage(null, damagePerTurn)
        if (duration == 0) {
            remove(entity)
        }
    }
}