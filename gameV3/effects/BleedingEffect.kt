package gameV3.effects

import gameV3.entities.Entity

class BleedingEffect(duration: Int, val damagePerTurn: Int): Effect(duration) {
    override fun update(entity: Entity) {
        duration--
        entity.receiveDamage(damagePerTurn)
        if (duration == 0) {
            remove(entity)
        }
    }

    override fun apply(entity: Entity) {
        entity.addEffect(this)
    }

    override fun remove(entity: Entity) {
        entity.removeEffect(this)
    }

}