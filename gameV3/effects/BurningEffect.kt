package gameV3.effects

import gameV3.entities.Entity

class BurningEffect(duration: Int, private val damagePerTurn: Long): Effect(duration) {

    override fun update(entity: Entity) {
        duration--
        entity.receiveDamage(null, damagePerTurn)
        if (duration == 0) {
            remove(entity)
        }
    }

    override fun remove(entity: Entity) {
        entity.removeEffect(this)
    }

}