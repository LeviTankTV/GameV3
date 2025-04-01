package gameV3.player.spells

import gameV3.entities.Entity
import gameV3.main.Game

class BloodMagicSpell() : Spell(name = "Магия Крови") {
    fun cast(attacker: Entity, target: Entity) {
        target.health -= target.level * 17
        attacker.health += target.level * 17
        println("${target.name} получил урон в размере ${target.level * 17}!")
        println("${attacker.name} восстановил здоровье!")
    }
}