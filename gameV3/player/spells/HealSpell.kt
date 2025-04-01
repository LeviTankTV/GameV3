package gameV3.player.spells

import gameV3.entities.Entity

class HealSpell() : Spell(name = "Магия Лечения") {
    override fun cast(target: Entity) {
        target.health += target.level * 10
        println("${target.name} восстановил здоровье!")
    }
}